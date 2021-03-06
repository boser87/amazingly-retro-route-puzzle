# amazingly-retro-route-puzzle

Uses DFS (Depth first search) with backtracking for exploring the graph.

- Language: Java 8
- Build automation tool: Gradle
- Testing library: JUnit, AssertJ
- Supporting libraries: Jackson (JSON parsing), Commons CLI (program arguments parsing)

In order to build/test the project through Docker:

- build Docker image: docker build -t mypuzzle .

- build the project in the Docker container: docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/build.sh

- run tests in the Docker container: docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/test.sh

A few examples to run the puzzle in the Docker container:

- docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/run.sh -f map1.json -r 2 -i Knife
- docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/run.sh -f map2.json -r 2 -i Pillow Knife
- docker run -v $(pwd):/mnt -w /mnt mypuzzle ./scripts/run.sh -f map2.json -r 2 -i "Potted Plant" Pillow Knife
