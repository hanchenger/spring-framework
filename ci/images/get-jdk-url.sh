#!/bin/bash
set -e

case "$1" in
	java17)
		echo "https://github.com/bell-sw/Liberica/releases/download/17.0.6+10/bellsoft-jdk17.0.6+10-linux-amd64.tar.gz"
	;;
	java20)
		echo "https://github.com/bell-sw/Liberica/releases/download/20%2B37/bellsoft-jdk20+37-linux-amd64.tar.gz"
	;;
  java21)
    echo "https://download.java.net/java/early_access/jdk21/18/GPL/openjdk-21-ea+18_linux-x64_bin.tar.gz"
  ;;
	*)
		echo $"Unknown java version"
		exit 1
esac
