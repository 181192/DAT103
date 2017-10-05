#! /bin/bash

for fil in $*
do
   ./filkontroll.sh  $fil "2" &
done
