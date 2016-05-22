s#!/bin/bash
echo -e "\033[33m=========================================================================\033[0m"
echo -e "\033[35m  >请输入临时秘钥：\033[0m"
read no
echo -e "\033[33m=========================================================================\033[0m"
if test "$no" -eq '594262005'
then
echo -e "\033[32m  输入成功，进入安装!!!\033[0m"
PATH=/bin:/sbin:/usr/bin:/usr/sbin:/usr/local/bin:/usr/local/sbin:~/bin
export PATH
clear;
cd /root
rm -f /root/LPSS.sh
#wget http://www.cwj95.com/shell/updata.sh & bash updata.sh
echo "程序获取中...."
clear
echo -e "\033[33m=========================================================================\033[0m"
echo -e "\033[36m            VPN MYSQL and pam_mysql Automatic installation\033[0m"
echo ""
echo -e "\033[31m                        【临时使用-----版本】\033[0m"
echo ""
echo -e "\033[32m        请选择安装版本：\033[0m"
echo -e "\033[32m                  1.常规 VPS  -http转接-本地数据库  -  自定义账号\033[0m"
echo -e "\033[32m                  2.常规 VPS  -http转接-远程数据库版本\033[0m"
echo -e "\033[32m                  3.常规 VPS  -  常规  -本地数据库  -  自定义账号\033[0m"
echo -e "\033[32m                  4.常规 VPS  -  常规  -远程数据库版本\033[0m"
echo -e "\033[32m                  5.常规 VPS  -  常规  -本地数据库(带web)版本\033[0m"
echo ""
echo -e "\033[32m                  6.网易容器  -http转接-本地数据库版本\033[0m"
echo -e "\033[32m                  7.网易容器  -http转接-远程数据库版本\033[0m"
echo -e "\033[32m                  8.网易容器  -  常规  -本地数据库版本\033[0m"
echo -e "\033[32m                  9.网易容器  -  常规  -远程数据库版本\033[0m"
echo ""
echo -e "\033[32m                                                            by 维护团队临时使用版本\033[0m"
echo -e "\033[35m  >请选择安装版本：\033[0m"
echo -e "\033[33m==========================================================================\033[0m"
read no
#rm -f updata.sh
case "$no" in
    '1' )
	wget http://www.cwj95.com/shell/CG/VPSMPB.sh && bash VPSMPB.sh;;
    '2' )
	wget http://www.cwj95.com/shell/CG/VPSMPY.sh && bash VPSMPY.sh ;;
    '3')
       wget http://www.cwj95.com/shell/CG/VPSCGB.sh && bash VPSCGB.sh ;;
    '4')
       wget http://www.cwj95.com/shell/CG/VPSCGY.sh && bash VPSCGY.sh ;;
    '5')
       echo "暂时不能安装，待以后开发";;
    '6' )
	wget http://www.cwj95.com/shell/RQ/RQMPB.sh && bash RQMPB.sh ;;
    '7' )
	wget http://www.cwj95.com/shell/RQ/RQMPY.sh && bash RQMPY.sh ;;
    '8')
       wget http://www.cwj95.com/shell/RQ/RQCGB.sh && bash RQCGB.sh ;;
    '9')
       wget http://www.cwj95.com/shell/RQ/RQCGY.sh && bash RQCGY.sh ;;
    *)
	echo "输入错误"
esac

else
rm -f ./LPSS.sh
echo -e "\033[31m     【秘钥输入错误，安装程序已终止!!】\033[0m"

fi