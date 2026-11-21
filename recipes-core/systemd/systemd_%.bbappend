FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://disable-tty1.conf \
    file://80-can.network \
"

do_install:append() {

    # Deshabilitar getty en tty1
    install -d ${D}${systemd_system_unitdir}/getty@tty1.service.d

    install -m 0644 ${WORKDIR}/disable-tty1.conf \
        ${D}${systemd_system_unitdir}/getty@tty1.service.d/

    # Configurar interfaz can0 a 500 kbps automáticamente
    install -d ${D}${systemd_unitdir}/network
    install -m 0644 ${WORKDIR}/80-can.network \
        ${D}${systemd_unitdir}/network/
}