DESCRIPTION = "An image containing packages that are required to conform \
to the Linux Standard Base (LSB) specification."

IMAGE_FEATURES += "splash ssh-server-openssh hwcodecs package-management"

IMAGE_INSTALL = "\
    ${CORE_IMAGE_BASE_INSTALL} \
    packagegroup-core-full-cmdline \
    packagegroup-core-lsb \
    "
IMAGE_INSTALL += "mtd-utils imx-kobs mtd-utils-ubifs"
inherit core-image  
#distro_features_check

#REQUIRED_DISTRO_FEATURES = "pam"

IMAGE_INSTALL += "kernel-dev"

LICENSE_FLAGS_WHITELIST = "commercial"
CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-fsl-gstreamer \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-gstreamer-full \
    packagegroup-fsl-tools-gpu-external \
    "

