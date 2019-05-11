# amazingly-retro-route-puzzle

- docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/build.sh

- docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/test.sh

- docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/run.sh -f map1.json -r 2 -i Knife
- docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/run.sh -f map2.json -r 2 -i Pillow Knife
- docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/run.sh -f map2.json -r 2 -i "Potted Plant" Pillow Knife
