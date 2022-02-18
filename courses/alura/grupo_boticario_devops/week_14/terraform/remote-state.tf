terraform {
    backend "remote" {
        hostname = "app.terraform.io"
        organization = "canto"

        workspaces {
            name = "aws-canto"
        }
    }
}