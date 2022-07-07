SUMMARY = "serverd"
DESCRIPTION = "A server based on the frameworkd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd
inherit cmake

DEPENDS += " frameworkd"

SRC_URI_append = "\
	git://github.com/zenitheesc/serverd;branch=develop;protocol=https \
"

S = "${WORKDIR}/git"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "serverd.service"

FILES_${PN} += "${systemd_unitdir}/system/serverd.service"

EXTRA_OECMAKE = ""
