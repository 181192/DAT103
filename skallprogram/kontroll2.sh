#! /bin/bash

for fil in "$@"
do
   (exec $HOME/dat103/skallprogram/filkontroll.sh $fil "2")
done
