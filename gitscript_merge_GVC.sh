#!/bin/bash
git switch GVC
git commit -am "$1  (`date`)"
git push -u origin GVC
git switch main
git pull
git merge
git push -u origin main
