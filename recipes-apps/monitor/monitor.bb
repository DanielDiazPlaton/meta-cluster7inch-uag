SUMMARY = "Programa Monitor"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# En esta nueva version de whinlatter, se debe de colocar en la carpeta de src todos los archivos
SRC_URI = "file://src"

# 2. Le indicamos a Bitbake que nuestra carpeta de trabajo (S) es esa subcarpeta
S = "${UNPACKDIR}/src"


do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} monitor.c -o monitor
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 monitor ${D}${bindir}
}