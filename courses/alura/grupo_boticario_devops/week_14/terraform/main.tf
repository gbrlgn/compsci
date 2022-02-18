provider "aws" {
    alias = "us-east-1"
    region = "us-east-1"
}

provider "aws" {
    alias = "us-east-2"
    region = "us-east-2"
}

resource "aws_instance" "dev" {
    count = 3
    ami = "ami-04505e74c0741db8d"
    instance_type = "t2.micro"
    key_name = "terraform-aws"
    tags = {
        Name = "dev${count.index}"
    }

    vpc_security_group_ids = ["${aws_security_group.acesso_ssh.id}"]
}

resource "aws_instance" "dev4" {
    ami = "ami-04505e74c0741db8d"
    instance_type = "t2.micro"
    key_name = "terraform-aws"
    tags = {
        Name = "dev4"
    }

    vpc_security_group_ids = ["${aws_security_group.acesso_ssh.id}"]

    depends_on = [aws_s3_bucket.dev4]
}

resource "aws_instance" "dev5" {
    ami = "ami-04505e74c0741db8d"
    instance_type = "t2.micro"
    key_name = "terraform-aws"
    tags = {
        Name = "dev5"
    }

    vpc_security_group_ids = ["${aws_security_group.acesso_ssh.id}"]
}

resource "aws_instance" "dev6" {
    provider = "aws.us-east-2"
    ami = "ami-0fb653ca2d3203ac1"
    instance_type = "t2.micro"
    key_name = "terraform-aws"
    tags = {
        Name = "dev6"
    }

    vpc_security_group_ids = ["${aws_security_group.acesso_ssh_us_east_2.id}"]
}

resource "aws_s3_bucket" "dev4" {
    bucket = "gxp-terraform-dev4"
    acl    = "private"
    tags = {
        Name = "gxp-terraform-dev4"
        Environment = "Dev"
    }
}