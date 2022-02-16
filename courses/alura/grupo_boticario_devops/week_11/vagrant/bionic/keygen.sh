ssh-keygen -t rsa ./id_bionic

vagrant ssh

cp /vagrant/id_bionic.pub .

cat id_bionic.pub >> .ssh/authorized_keys

exit

ssh -i id_bionic vagrant@192.168.1.24
