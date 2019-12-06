#!/bin/bash
for filename in joueurs/*; do
    echo "80 70 60 DEF\n">$filename
    echo "Real Madrid\n">>$filename
done
