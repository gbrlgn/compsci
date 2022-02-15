openssl req -x509 -nodes -days 30 -newkey rsa:2048 -keyout /tmp/localhost.key -out /tmp/localhost.crt

certutil -A -d sql:~/.pki/nssdb -t C -n "Certificate Common Name" -i cert.crt
