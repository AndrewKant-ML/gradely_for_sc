#!/bin/bash
git switch main
git commit -am "$1  (`date`)"
git push -u origin main
git switch GVC
git pull
git merge
git push -u origin GVC
