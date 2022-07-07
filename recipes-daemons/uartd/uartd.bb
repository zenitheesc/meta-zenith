SUMMARY = "uartd"
DESCRIPTION = "Daemon service based on the Frameworkd SDK to comunicate via UART"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd
inherit cmake

DEPENDS += " frameworkd"

SRC_URI_append = "\
	git://github.com/zenitheesc/uartd;branch=develop;protocol=https \
"

S = "${WORKDIR}/git"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "uartd.service"

FILES_${PN} += "${systemd_unitdir}/system/uartd.service"

EXTRA_OECMAKE = ""
