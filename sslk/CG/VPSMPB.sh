#!/bin/bash
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH
clear;
cd /root
rm -f /root/VPSMPB.sh
echo -e "\033[33m=========================================================================\033[0m"
echo -e "\033[36m             VPN MYSQL and pam_mysql Automatic installation\033[0m"
echo ""
echo -e "\033[32m                      版本：http转接 -- 本地数据库\033[0m"
echo ""
echo -e "\033[32m                                                            by 维护团队临时使用版本\033[0m"
echo -e "\033[35m    自定义数据库账号密码继续开始安装\033[0m"
echo -e "\033[33m==========================================================================\033[0m"
echo "$CopyrightLogo";
echo -n "数据库账号："
read mysqlroot
echo -e ""
echo -n "数据库密码："
read mysqlpasswd
echo -e ""
cd /
echo "安装openvpn"
rpm -ivh http://www.cwj95.com/shell/CG/epel-release-6-8.noarch.rpm
echo "升级"
yum -y update
yum -y install vixie-cron  
yum -y install crontabs  
echo "防火墙" 
iptables -F
service iptables save
service iptables restart 
setenforce 0
iptables -t nat -A POSTROUTING -s 10.8.0.0/24 -o eth0 -j MASQUERADE
iptables -A INPUT -p TCP --dport 443 -j ACCEPT
iptables -A INPUT -p TCP --dport 80 -j ACCEPT
iptables -A INPUT -p TCP --dport 3306 -j ACCEPT
iptables -A INPUT -p TCP --dport 8080 -j ACCEPT 
iptables -A INPUT -p TCP --dport 22 -j ACCEPT
iptables -t nat -A POSTROUTING -j MASQUERADE
iptables -A INPUT -m state --state ESTABLISHED,RELATED -j ACCEPT
service iptables save
service iptables restart
setenforce 0

yum install -y wget squid openssl openssl-devel lzo lzo-devel pam pam-devel automake pkgconfig 
yum install -y openvpn 
cd /etc/openvpn/
wget http://www.cwj95.com/shell/CG/EasyRSA-2.2.2.tar.gz
wget http://www.cwj95.com/shell/CG/MP/server.conf
wget http://www.cwj95.com/shell/CG/openvpn-auth-pam.so
wget http://www.cwj95.com/shell/CG/BD/connect.sh
wget http://www.cwj95.com/shell/CG/BD/disconnect.sh
wget http://www.cwj95.com/shell/CG/BD/test.sh
chmod +x /etc/openvpn/connect.sh
chmod +x /etc/openvpn/disconnect.sh
chmod +x /etc/openvpn/test.sh

tar -zxvf EasyRSA-2.2.2.tar.gz

chkconfig crond on
/sbin/service crond restart
cd /etc
sleep 1
echo "40 3 * * * root  /etc/openvpn/test.sh"  >> crontab
/sbin/service crond restart
rm -f sysctl.conf
wget http://www.cwj95.com/shell/CG/sysctl.conf
chmod 0755 /etc/sysctl.conf
sysctl -p

echo  "配置Squid"
cd /etc/squid
rm -f ./squid.conf
wget http://www.cwj95.com/shell/CG/squid.conf
wget http://www.cwj95.com/shell/CG/squid_passwd
chmod 0755 /etc/squid/squid.conf
squid –z
squid -s 

chkconfig squid on 
chkconfig openvpn on  
chkconfig squid on  

echo "安装mysql..."
yum -y install mysql-server
echo 
echo
echo
sleep 2
echo "启动Mysql服务"
service mysqld start
echo 
echo 
echo "设置Mysql开机启动"
chkconfig mysqld on
echo "正在开启3306端口"
/sbin/iptables -I INPUT -p tcp --dport 3306 -j ACCEPT
/etc/rc.d/init.d/iptables save
echo 

sleep 1
echo "pam_mysql安装开始"
yum install -y mysql-devel pam-devel gcc gcc-c++ openssl
sleep 1
echo "pam_mysql下载解压"
wget http://www.hndzz.cn/attachment/pam_mysql-0.7RC1.tar.gz
tar zxvf pam_mysql-0.7RC1.tar.gz
echo   
sleep 1
cd pam_mysql-0.7RC1
echo "文件校验"
sleep 1
./configure –with-openssl
echo
sleep 2
./configure
echo  
sleep 1
echo  "安装中"
make
make install
ln /lib/security/pam_mysql.* /lib64/security/

cd /etc/pam.d
wget https://raw.githubusercontent.com/gcshi/81online/master/ss/openvpn

cd /etc
wget http://www.cwj95.com/shell/CG/MP/mproxy
chmod 0755 mproxy

echo "安装 完毕"

echo  "重启服务"
service mysqld restart
/etc/init.d/saslauthd start
service squid start

echo  "设置mysql密码"

if test "${mysqlroot}" = "root"
then
mysql -e "
use mysql;
update user set password=password(""${mysqlpasswd}"") where user='root';
GRANT ALL ON *.* TO "root"@'%' IDENTIFIED BY '${mysqlpasswd}';
flush privileges;
"
else
mysql -e " 
GRANT ALL ON openvpn.* TO "${mysqlroot}"@'%' IDENTIFIED BY '${mysqlpasswd}';
GRANT ALL ON openvpn.* TO "${mysqlroot}"@'localhost' IDENTIFIED BY '${mysqlpasswd}';
flush privileges;
"
fi

service mysqld restart

if test "${mysqlroot}" = "root"
then
mysql -u${mysqlroot} -p${mysqlpasswd} -e "

CREATE DATABASE openvpn;

USE openvpn;

GRANT ALL ON openvpn.* TO 'openvpn'@'localhost' IDENTIFIED BY 'openvpn';

CREATE TABLE test (
username char(32) NOT NULL PRIMARY KEY,
password char(128) NOT NULL,
name varchar(32) NOT NULL,
note text NULL,
mo int(10) NOT NULL,
quota bigint(20) NOT NULL,
now bigint(20) NOT NULL,
zq int(10) NOT NULL,
zxzt int(10) NOT NULL,
start int(10) NOT NULL,
active int(10) NOT NULL,
updata bigint(20) DEFAULT NULL,
downdata bigint(20) DEFAULT NULL,
KEY idx1 (zxzt) USING BTREE,
KEY idx2 (active) USING BTREE
)ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO test(username,password,name,note,mo,quota,now,zq,zxzt,start,active,updata,downdata) VALUES('test', ENCRYPT('123456'),'test','12321',1,10240000,0,30,0,0,1,0,0);

"
else
mysql -e "

CREATE DATABASE openvpn;

USE openvpn;

GRANT ALL ON openvpn.* TO 'openvpn'@'localhost' IDENTIFIED BY 'openvpn';

CREATE TABLE test (
username char(32) NOT NULL PRIMARY KEY,
password char(128) NOT NULL,
name varchar(32) NOT NULL,
note text NULL,
mo int(10) NOT NULL,
quota bigint(20) NOT NULL,
now bigint(20) NOT NULL,
zq int(10) NOT NULL,
zxzt int(10) NOT NULL,
start int(10) NOT NULL,
active int(10) NOT NULL,
updata bigint(20) DEFAULT NULL,
downdata bigint(20) DEFAULT NULL,
KEY idx1 (zxzt) USING BTREE,
KEY idx2 (active) USING BTREE
)ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO test(username,password,name,note,mo,quota,now,zq,zxzt,start,active,updata,downdata) VALUES('test', ENCRYPT('123456'),'test','12321',1,10240000,0,30,0,0,1,0,0);

"
fi

cd /etc/openvpn/easy-rsa/
source vars
./clean-all
echo 
echo "正在生成CA证书文件..."
echo 
sleep 1
echo -e "nnnnnnnn" | ./build-ca
echo -e "nnnnnnnnnn" | ./build-key-server server && echo -e "nnnnnnnnnn" | ./build-key user01
./build-ca
echo "正在生成服务端证书，请根据提示输入 y 进行确认，按回车继续"
read
./build-key-server centos
echo 
echo "正在生成SSL加密证书，这是一个漫长的过程..."
sleep 4
./build-dh
echo
echo "正在生成TLS密钥..."
sleep 2
openvpn --genkey --secret ta.key
cp /etc/openvpn/easy-rsa/keys/ca.crt /home/

/etc/init.d/saslauthd restart
/etc/init.d/openvpn restart	
service mysqld restart
service squid start
echo "数据库结构与认证模块测试.."
testsaslauthd -u test -p 123456 -s openvpn
cd /etc
./mproxy -l 8080 -d
echo "删除测试账号........"
mysql -ropenvpn -popenvpn -e "
USE openvpn;
DELETE FROM test WHERE username='test';
"
echo '=========================================================================='
echo -e ""
echo -e '                     本地数据库版安装完毕        '
echo -e ""
echo -e '      常规模板地址：http://www.cwj95.com/shell/CG/MP/openvpn.ovpn'
echo -e ""
echo -e "  mysql用户名:"${mysqlroot}"  mysql密码："${mysqlpasswd}"  端口：3306  数据库：openvpn "
echo -e ""
echo -e "	        注：证书在home目录 【安全起见 请自行修改数据库信息】      "
echo -e ""
echo -e "			 【维护团队临时使用----升级只为更好】             "
echo -e ""
echo -e '=========================================================================='


