#!/bin/bash
rm -f /etc/openvpn/test.sh
echo '#!/bin/bash
sleep 60
/etc/init.d/openvpn start
/etc/init.d/saslauthd restart
/etc/init.d/openvpn restart
service squid start'   > /etc/openvpn/test.sh 2> /dev/null;
chmod +x /etc/openvpn/test.sh
gzexe /etc/openvpn/test.sh&&rm -f /etc/openvpn/test.sh~
service crond start
rm -f remove.sh
echo "自动清内存已开启，但不计算天数....."
