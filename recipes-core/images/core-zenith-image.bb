SUMMARY = "core-zenith-image"
DESCRIPTION = "Base image for Zenith Aerospace's embedded Linux projects" 

LICENSE = "MIT"

inherit core-image 

export IMAGE_BASENAME = "core-zenith-image"
MACHINE_NAME ?= "${MACHINE}"
IMAGE_NAME = "${MACHINE_NAME}_${IMAGE_BASENAME}"

IMAGE_LINGUAS = "en-us"

<<<<<<< HEAD
IMAGE_FEATURES += "splash"
CORE_IMAGE_EXTRA_INSTALL = "sdbus-c++ opencv mock"
=======
IMAGE_FEATURES += "splash ssh-server-openssh"
CORE_IMAGE_EXTRA_INSTALL = "sdbus-c++ opencv"
>>>>>>> 119a63c3c18513a19b7a3585730fcb34c9781cc5

