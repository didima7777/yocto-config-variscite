SUMMARY = "A console-only image that fully supports the target device \
hardware."

IMAGE_FEATURES += "splash ssh-server-openssh hwcodecs package-management"

IMAGE_FEATURES += "tools-sdk dev-pkgs tools-debug eclipse-debug tools-profile tools-testapps debug-tweaks"
IMAGE_INSTALL += "kernel-dev"
IMAGE_INSTALL += "mtd-utils imx-kobs mtd-utils-ubifs"

LICENSE = "MIT"

inherit core-image
