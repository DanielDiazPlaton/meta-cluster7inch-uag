SUMMARY = "Imagen Cluster 7 inches"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit core-image

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    monitor \
"

IMAGE_FEATURES += "ssh-server-dropbear"

IMAGE_FSTYPES += "wic.bz2 wic.bmap"