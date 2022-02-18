resource "aws_security_group" "acesso_ssh" {
    name = "acesso_ssh"
    description = "acesso_ssh"

    ingress = [
        {
            description = "acesso_ssh"
            from_port = 22
            to_port = 22
            protocol = "tcp"
            
            cidr_blocks = ["152.244.252.0/24"]
            ipv6_cidr_blocks = []
            prefix_list_ids = []
            security_groups = []
            self = true
        }
    ]
}