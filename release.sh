#!/bin/bash

git checkout master
rm -rf ./*
git checkout dev -- _site/
mv _site/* .
rm -rf _site/
git add -A .
git commit -m "see dev branch for release commit log"
git push origin master
git checkout dev
