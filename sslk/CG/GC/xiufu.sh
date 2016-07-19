#!/bin/bash
rm -f /etc/pam.d/openvpn
cd /etc/pam.d/
wget https://github.com/gcshi/yun/raw/master/sslk/CG/GC/openvpn
/etc/init.d/saslauthd restart
rm -f xiufu.sh
echo "是的，你没有看错，修复成功了！！！！请使用检测，谢谢支持!!"
echo 
echo "因存在客户数据，脚本在1个小时后不可用！！"