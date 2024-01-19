#!/bin/bash

set e;
clear # Clear the screen.

#===============================================
# COMMON PATHS
ROLL_DICE_COMMON_ROOT=../../com.aw.dpa.common;

#================================================
e_header "Building roll dice instance. Please wait..."
cd ${ROLL_DICE_COMMON_ROOT};
mvn clean install -DskipTests;

rc=$?
if [[ $rc -ne 0 ]] ; then
  e_header 'Check you build and make sure you sync all repos';
  exit $rc
fi
#================================================
e_header "Starting roll dice instance. Please wait..."
java -jar RollTheDice.jar
