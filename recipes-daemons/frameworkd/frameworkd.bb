SUMMARY = "frameworkd"
DESCRIPTION = "A framework for creating daemons in our architecture"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# inherit systemd
inherit cmake

DEPENDS += " nlohmann-json sdbus-c++"

SRC_URI_append = "\
	git://github.com/zenitheesc/frameworkd;branch=develop;protocol=https \
"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = ""
