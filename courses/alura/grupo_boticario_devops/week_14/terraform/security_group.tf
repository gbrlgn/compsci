resource "aws_security_group" "acesso_ssh" {
    name = "acesso_ssh"
    description = "acesso_ssh"

    ingress = [
        {
            description = "acesso_ssh"
            from_port = 22
            to_port = 22
            protocol = "tcp"
            
            cidr_blocks = var.cidrs_acesso_remoto
            ipv6_cidr_blocks = []
            prefix_list_ids = []
            security_groups = []
            self = true
        }
    ]
}

resource "aws_security_group" "acesso_ssh_us_east_2" {
    provider = aws.us-east-2
    name = "acesso_ssh"
    description = "acesso_ssh"

    ingress = [
        {
            description = "acesso_ssh"
            from_port = 22
            to_port = 22
            protocol = "tcp"
            
            cidr_blocks = var.cidrs_acesso_remoto
            ipv6_cidr_blocks = []
            prefix_list_ids = []
            security_groups = []
            self = true
        }
    ]
}