cd src
python separar_dados.py
javac -cp . RunSimulator.java
java -cp . RunSimulator first-fit 0.20 0.02
java -cp . RunSimulator first-fit 0.55 0.02
java -cp . RunSimulator first-fit 1 0.02
java -cp . RunSimulator first-fit 0.20 0.1
java -cp . RunSimulator first-fit 0.55 0.1
java -cp . RunSimulator first-fit 1 0.1
java -cp . RunSimulator first-fit 0.20 0.4
java -cp . RunSimulator first-fit 0.55 0.4
java -cp . RunSimulator first-fit 1 0.4

java -cp . RunSimulator worst-fit 0.20 0.02
java -cp . RunSimulator worst-fit 0.55 0.02
java -cp . RunSimulator worst-fit 1 0.02
java -cp . RunSimulator worst-fit 0.20 0.1
java -cp . RunSimulator worst-fit 0.55 0.1
java -cp . RunSimulator worst-fit 1 0.1
java -cp . RunSimulator worst-fit 0.20 0.4
java -cp . RunSimulator worst-fit 0.55 0.4
java -cp . RunSimulator worst-fit 1 0.4

java -cp . RunSimulator best-fit 0.20 0.02
java -cp . RunSimulator best-fit 0.55 0.02
java -cp . RunSimulator best-fit 1 0.02
java -cp . RunSimulator best-fit 0.20 0.1
java -cp . RunSimulator best-fit 0.55 0.1
java -cp . RunSimulator best-fit 1 0.1
java -cp . RunSimulator best-fit 0.20 0.4
java -cp . RunSimulator best-fit 0.55 0.4
java -cp . RunSimulator best-fit 1 0.4
