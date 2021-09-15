FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://hostapd.conf \
"

SYSTEMD_AUTO_ENABLE_${PN} = "enable"

do_install_append() {
    install -m 0644 ${WORKDIR}/hostapd.conf ${D}${sysconfdir}
}

