FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://disable-tty1.conf"

do_install:append() {

    install -d ${D}${systemd_system_unitdir}/getty@tty1.service.d

    install -m 0644 ${WORKDIR}/disable-tty1.conf \
        ${D}${systemd_system_unitdir}/getty@tty1.service.d/
}