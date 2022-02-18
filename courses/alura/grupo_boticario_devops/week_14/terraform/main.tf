provider "aws" {
    region = "us-east-1"
}

resource "aws_instance" "dev" {
    count = 3
    ami = "ami-04505e74c0741db8d"
    instance_type = "t2.micro"
    key_name = "terraform-aws"
    tags = {
        Name = "dev${count.index}"
    }
}

resource "aws_security_group" "acesso_ssh" {
    name = "acesso_ssh"
    description = "acesso_ssh"

    ingress = [
        {
            description = "acesso_ssh"
            from_port = 22
            to_port = 22
            protocol = "tcp"
            
            cidr_blocks = ["152.244.252.25/32"]
            ipv6_cidr_blocks = []
            prefix_list_ids = []
            security_groups = []
            self = true
        }
    ]
}