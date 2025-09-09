package ai;

import main.GamePanel;
import main.KeyHandler;
import objects.Player;

public class NeuralNetwork {

	GamePanel gp;
	KeyHandler keyH;

	public int[] changeList = new int[16];

	public boolean ai = false;
	public double totalLayerEnd;

	public double name1;
	public double name2;
	public double newHp1;
	public double newHp2;
	public int left;

	static public int success;
	static public int totalWinLoss;

	public double bestAction;

	public boolean win;

	public double[] inputNum = new double[13]; // f
	public double[][] inputBridge = new double[13][5];
	public double[] layer1 = new double[5]; // f
	public double[][] bridge1 = new double[5][5];
	public double[] layer2 = new double[5]; // f
	public double[][] bridge2 = new double[5][5];
	public double[] layer3 = new double[5]; // f
	public double[][] bridge3 = new double[5][10];
	public double[] layerEnd = new double[10]; // f

	public NeuralNetwork(int left, GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		this.left = left;
		bridgeReset();
		randomBridge();
		inputBridge[changeList[0]][changeList[1]] += 0.1;
		bridge1[changeList[2]][changeList[3]] += 0.1;
		bridge2[changeList[4]][changeList[5]] += 0.1;
		bridge3[changeList[6]][changeList[7]] += 0.1;
		inputBridge[changeList[8]][changeList[9]] += 0.1;
		bridge1[changeList[10]][changeList[11]] += 0.1;
		bridge2[changeList[12]][changeList[13]] += 0.1;
		bridge3[changeList[14]][changeList[15]] += 0.1;
	}

	public int randomNum(int max) {
		return (int) (Math.random() * max);
	}

	public void randomBridge() {
		changeList[0] = randomNum(13);
		changeList[1] = randomNum(5);
		changeList[2] = randomNum(5);
		changeList[3] = randomNum(5);
		changeList[4] = randomNum(5);
		changeList[5] = randomNum(5);
		changeList[6] = randomNum(5);
		changeList[7] = randomNum(10);

//		if (left == 0) {
//			if (win == false || gp.player1.hp < (gp.player1.maxHp / 3) || Player.aiTrainingTimer < 2000) {
//				changeList[8] = randomNum(13);
//				changeList[9] = randomNum(5);
//				changeList[10] = randomNum(5);
//				changeList[11] = randomNum(5);
//				changeList[12] = randomNum(5);
//				changeList[13] = randomNum(5);
//				changeList[14] = randomNum(5);
//				changeList[15] = randomNum(10);
//			}
//		} else if (left == 1) {
//			if (win == false || gp.player2.hp < (gp.player2.maxHp / 3) || Player.aiTrainingTimer < 2000) {
//				changeList[8] = randomNum(13);
//				changeList[9] = randomNum(5);
//				changeList[10] = randomNum(5);
//				changeList[11] = randomNum(5);
//				changeList[12] = randomNum(5);
//				changeList[13] = randomNum(5);
//				changeList[14] = randomNum(5);
//				changeList[15] = randomNum(10);
//			}
//		}
	}

	public void changeBridge() {

//		if (left == 0) {
//			if (win == false || gp.player1.hp < (gp.player1.maxHp / 3) || Player.aiTrainingTimer > 2000) {
//				inputBridge[changeList[0]][changeList[1]] -= 0.01;
//				bridge1[changeList[2]][changeList[3]] -= 0.01;
//				bridge2[changeList[4]][changeList[5]] -= 0.01;
//				bridge3[changeList[6]][changeList[7]] -= 0.01;
//				inputBridge[changeList[8]][changeList[9]] -= 0.01;
//				bridge1[changeList[10]][changeList[11]] -= 0.01;
//				bridge2[changeList[12]][changeList[13]] -= 0.01;
//				bridge3[changeList[14]][changeList[15]] -= 0.01;
//				success++;
//			}
//		} else if (left == 1) {
//			if (win == false || gp.player2.hp < (gp.player2.maxHp / 3) || Player.aiTrainingTimer > 2000) {
//				inputBridge[changeList[0]][changeList[1]] -= 0.01;
//				bridge1[changeList[2]][changeList[3]] -= 0.01;
//				bridge2[changeList[4]][changeList[5]] -= 0.01;
//				bridge3[changeList[6]][changeList[7]] -= 0.01;
//				inputBridge[changeList[8]][changeList[9]] -= 0.01;
//				bridge1[changeList[10]][changeList[11]] -= 0.01;
//				bridge2[changeList[12]][changeList[13]] -= 0.01;
//				bridge3[changeList[14]][changeList[15]] -= 0.01;
//				success++;
//			}
//		}

		if (gp.ai1.win == true) {
			for (int i = 0; i < 5; i++) {
				for (int a = 0; a < 13; a++)
					gp.ai2.inputBridge[a][i] = gp.ai1.inputBridge[a][i];
			}

			for (int i = 0; i < 5; i++) {
				for (int a = 0; a < 5; a++)
					gp.ai2.bridge1[a][i] = gp.ai1.bridge1[a][i];
			}

			for (int i = 0; i < 5; i++) {
				for (int a = 0; a < 5; a++)
					gp.ai2.bridge2[a][i] = gp.ai1.bridge2[a][i];
			}

			for (int i = 0; i < 10; i++) {
				for (int a = 0; a < 5; a++)
					gp.ai2.bridge3[a][i] = gp.ai1.bridge3[a][i];
			}

		} else if (gp.ai2.win == true) {
			for (int i = 0; i < 5; i++) {
				for (int a = 0; a < 13; a++)
					gp.ai1.inputBridge[a][i] = gp.ai2.inputBridge[a][i];
			}

			for (int i = 0; i < 5; i++) {
				for (int a = 0; a < 5; a++)
					gp.ai1.bridge1[a][i] = gp.ai2.bridge1[a][i];
			}

			for (int i = 0; i < 5; i++) {
				for (int a = 0; a < 5; a++)
					gp.ai1.bridge2[a][i] = gp.ai2.bridge2[a][i];
			}

			for (int i = 0; i < 10; i++) {
				for (int a = 0; a < 5; a++)
					gp.ai1.bridge3[a][i] = gp.ai2.bridge3[a][i];
			}
		}

//		if (left == 0) {
//			if (win == true && gp.player1.hp > (gp.player1.maxHp / 3) && Player.aiTrainingTimer < 2000
//					&& gp.player1.atkCR > 30) {
//				inputBridge[changeList[0]][changeList[1]] += 0.3;
//				bridge1[changeList[2]][changeList[3]] += 0.3;
//				bridge2[changeList[4]][changeList[5]] += 0.3;
//				bridge3[changeList[6]][changeList[7]] += 0.3;
//				inputBridge[changeList[8]][changeList[9]] += 0.3;
//				bridge1[changeList[10]][changeList[11]] += 0.3;
//				bridge2[changeList[12]][changeList[13]] += 0.3;
//				bridge3[changeList[14]][changeList[15]] += 0.3;
//				System.out.println("b");
//			}
//		} else if (left == 1) {
//			if (win == true && gp.player2.hp > (gp.player2.maxHp / 3) && Player.aiTrainingTimer < 2000
//					&& gp.player2.atkCR > 0.1) {
//				inputBridge[changeList[0]][changeList[1]] += 0.3;
//				bridge1[changeList[2]][changeList[3]] += 0.3;
//				bridge2[changeList[4]][changeList[5]] += 0.3;
//				bridge3[changeList[6]][changeList[7]] += 0.3;
//				inputBridge[changeList[8]][changeList[9]] += 0.3;
//				bridge1[changeList[10]][changeList[11]] += 0.3;
//				bridge2[changeList[12]][changeList[13]] += 0.3;
//				bridge3[changeList[14]][changeList[15]] += 0.3;
//				System.out.println("b");
//			}
//		}

		randomBridge();
		inputBridge[changeList[0]][changeList[1]] += 0.01;
		bridge1[changeList[2]][changeList[3]] += 0.01;
		bridge2[changeList[4]][changeList[5]] += 0.01;
		bridge3[changeList[6]][changeList[7]] += 0.01;
		inputBridge[changeList[8]][changeList[9]] += 0.01;
		bridge1[changeList[10]][changeList[11]] += 0.01;
		bridge2[changeList[12]][changeList[13]] += 0.01;
		bridge3[changeList[14]][changeList[15]] += 0.01;

//		if (win == true && gp.player1.hp > (gp.player1.maxHp / 3) && Player.aiTrainingTimer < 2000) {
//		}

	}

	public void printBridge() {
		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < 13; a++)
				System.out.println("inputBridge[" + a + "][" + i + "] = " + inputBridge[a][i] + ";");
		}

		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < 5; a++)
				System.out.println("bridge1[" + a + "][" + i + "] =" + bridge1[a][i] + ";");
		}

		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < 5; a++)
				System.out.println("bridge2[" + a + "][" + i + "] =" + bridge2[a][i] + ";");
		}

		for (int i = 0; i < 10; i++) {
			for (int a = 0; a < 5; a++)
				System.out.println("bridge3[" + a + "][" + i + "] =" + bridge3[a][i] + ";");
		}
	}

	public void bridgeReset() {
		inputBridge[0][0] = 30.528580540001755;
		inputBridge[1][0] = 28.73537430000148;
		inputBridge[2][0] = 29.693617610001624;
		inputBridge[3][0] = 30.28980661000172;
		inputBridge[4][0] = 30.21537261000171;
		inputBridge[5][0] = 29.094908010001536;
		inputBridge[6][0] = 27.888636110001343;
		inputBridge[7][0] = 30.00474655000167;
		inputBridge[8][0] = 29.26882693000156;
		inputBridge[9][0] = 29.429408300001583;
		inputBridge[10][0] = 30.039382400001678;
		inputBridge[11][0] = 29.56816941000161;
		inputBridge[12][0] = 30.510581200001752;
		inputBridge[0][1] = 30.246220300001717;
		inputBridge[1][1] = 29.866515500001654;
		inputBridge[2][1] = 29.901497600001658;
		inputBridge[3][1] = 29.40065091000158;
		inputBridge[4][1] = 29.63587750000162;
		inputBridge[5][1] = 29.342640320001568;
		inputBridge[6][1] = 30.497211200001754;
		inputBridge[7][1] = 28.54445743000145;
		inputBridge[8][1] = 30.89415031000182;
		inputBridge[9][1] = 30.226279610001722;
		inputBridge[10][1] = 30.054042500001678;
		inputBridge[11][1] = 30.419417610001737;
		inputBridge[12][1] = 30.25386771000171;
		inputBridge[0][2] = 29.66249623000163;
		inputBridge[1][2] = 30.569220510001763;
		inputBridge[2][2] = 30.93964903000182;
		inputBridge[3][2] = 29.464705500001596;
		inputBridge[4][2] = 30.024707820001673;
		inputBridge[5][2] = 29.56587611000161;
		inputBridge[6][2] = 30.29796422000172;
		inputBridge[7][2] = 28.918316800001513;
		inputBridge[8][2] = 30.095218110001692;
		inputBridge[9][2] = 29.620921620001614;
		inputBridge[10][2] = 29.5539075200016;
		inputBridge[11][2] = 29.94338830000166;
		inputBridge[12][2] = 29.37600063000158;
		inputBridge[0][3] = 29.420070900001583;
		inputBridge[1][3] = 30.710565120001785;
		inputBridge[2][3] = 29.004062320001523;
		inputBridge[3][3] = 30.265304700001717;
		inputBridge[4][3] = 30.651875900001773;
		inputBridge[5][3] = 29.548719150001602;
		inputBridge[6][3] = 29.288017010001564;
		inputBridge[7][3] = 29.226588820001556;
		inputBridge[8][3] = 29.838731730001648;
		inputBridge[9][3] = 30.223664610001705;
		inputBridge[10][3] = 30.321413510001722;
		inputBridge[11][3] = 30.91482701000181;
		inputBridge[12][3] = 29.618546610001616;
		inputBridge[0][4] = 30.789860400001796;
		inputBridge[1][4] = 29.858217240001654;
		inputBridge[2][4] = 28.869759930001496;
		inputBridge[3][4] = 29.915548210001663;
		inputBridge[4][4] = 28.185087430001396;
		inputBridge[5][4] = 29.689826120001623;
		inputBridge[6][4] = 29.274009300001566;
		inputBridge[7][4] = 30.213730410001702;
		inputBridge[8][4] = 30.43051860000174;
		inputBridge[9][4] = 30.471939910001748;
		inputBridge[10][4] = 29.090210620001532;
		inputBridge[11][4] = 29.692742010001623;
		inputBridge[12][4] = 30.48163101000175;
		bridge1[0][0] = 79.28633331000285;
		bridge1[1][0] = 78.10187774000227;
		bridge1[2][0] = 77.2123766100018;
		bridge1[3][0] = 76.47133884000142;
		bridge1[4][0] = 77.49644685000193;
		bridge1[0][1] = 77.57621592000199;
		bridge1[1][1] = 78.54851035000247;
		bridge1[2][1] = 77.88935964000216;
		bridge1[3][1] = 78.2039219100023;
		bridge1[4][1] = 76.28812674000133;
		bridge1[0][2] = 78.23318503000232;
		bridge1[1][2] = 77.4044993300019;
		bridge1[2][2] = 77.29642172000185;
		bridge1[3][2] = 79.23357785000283;
		bridge1[4][2] = 78.14285002000229;
		bridge1[0][3] = 77.71511542000205;
		bridge1[1][3] = 76.19801241000128;
		bridge1[2][3] = 76.86417587000162;
		bridge1[3][3] = 77.75014125000209;
		bridge1[4][3] = 76.46064857000141;
		bridge1[0][4] = 76.8052833300016;
		bridge1[1][4] = 77.0497686200017;
		bridge1[2][4] = 77.94544272000218;
		bridge1[3][4] = 77.19975366000179;
		bridge1[4][4] = 77.20610675000178;
		bridge2[0][0] = 77.10704084000176;
		bridge2[1][0] = 78.61675224000251;
		bridge2[2][0] = 77.05459013000171;
		bridge2[3][0] = 78.34244264000237;
		bridge2[4][0] = 78.26480631000234;
		bridge2[0][1] = 77.84017225000211;
		bridge2[1][1] = 77.86165403000214;
		bridge2[2][1] = 77.07901893000172;
		bridge2[3][1] = 78.68971535000254;
		bridge2[4][1] = 78.5765715300025;
		bridge2[0][2] = 77.50418404000195;
		bridge2[1][2] = 79.59981010000303;
		bridge2[2][2] = 76.52570990000146;
		bridge2[3][2] = 77.45871116000193;
		bridge2[4][2] = 77.45024253000192;
		bridge2[0][3] = 79.19257236000281;
		bridge2[1][3] = 76.48075025000144;
		bridge2[2][3] = 76.20261657000128;
		bridge2[3][3] = 77.18331444000178;
		bridge2[4][3] = 76.87969592000162;
		bridge2[0][4] = 78.30950732000235;
		bridge2[1][4] = 77.26010461000182;
		bridge2[2][4] = 76.16825986000126;
		bridge2[3][4] = 76.59350363000148;
		bridge2[4][4] = 76.33774352000135;
		bridge3[0][0] = 37.59327421000076;
		bridge3[1][0] = 38.009662210000684;
		bridge3[2][0] = 38.4269840500006;
		bridge3[3][0] = 38.21534992000064;
		bridge3[4][0] = 39.49498193000038;
		bridge3[0][1] = 37.330005410000815;
		bridge3[1][1] = 39.83532291000032;
		bridge3[2][1] = 38.54541792000058;
		bridge3[3][1] = 37.411120540000795;
		bridge3[4][1] = 38.9008798400005;
		bridge3[0][2] = 38.84058073000051;
		bridge3[1][2] = 38.9291408600005;
		bridge3[2][2] = 39.08903653000047;
		bridge3[3][2] = 38.87014742000051;
		bridge3[4][2] = 38.431880400000594;
		bridge3[0][3] = 37.33268642000082;
		bridge3[1][3] = 38.490325410000594;
		bridge3[2][3] = 38.9116326100005;
		bridge3[3][3] = 37.973171820000694;
		bridge3[4][3] = 38.17620931000066;
		bridge3[0][4] = 38.11380431000065;
		bridge3[1][4] = 38.72867744000054;
		bridge3[2][4] = 38.75143952000053;
		bridge3[3][4] = 39.82213591000033;
		bridge3[4][4] = 37.703967240000736;
		bridge3[0][5] = 38.4284837000006;
		bridge3[1][5] = 38.3832821300006;
		bridge3[2][5] = 39.275569720000426;
		bridge3[3][5] = 38.207893510000645;
		bridge3[4][5] = 39.01673312000048;
		bridge3[0][6] = 40.33179182000023;
		bridge3[1][6] = 39.080828430000466;
		bridge3[2][6] = 39.70224434000034;
		bridge3[3][6] = 39.19545150000045;
		bridge3[4][6] = 38.65820432000056;
		bridge3[0][7] = 38.96447422000049;
		bridge3[1][7] = 40.24026470000024;
		bridge3[2][7] = 38.252758610000626;
		bridge3[3][7] = 39.28723663000043;
		bridge3[4][7] = 39.409113440000404;
		bridge3[0][8] = 39.57946422000037;
		bridge3[1][8] = 38.898624700000504;
		bridge3[2][8] = 39.448638610000394;
		bridge3[3][8] = 39.29443663000043;
		bridge3[4][8] = 37.72383344000073;
		bridge3[0][9] = 38.16003422000065;
		bridge3[1][9] = 39.14707470000046;
		bridge3[2][9] = 38.930558610000496;
		bridge3[3][9] = 39.59551663000037;
		bridge3[4][9] = 39.464883440000385;
	}

	public double largeNum(double a, double b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	public double largeNum10(double a, double b, double c, double d, double e, double f, double g, double h, double i,
			double j) {
		return largeNum(a, largeNum(b,
				largeNum(c, largeNum(d, largeNum(e, largeNum(f, largeNum(g, largeNum(h, largeNum(i, j)))))))));
	}

	public void calculateOutputH() {

		totalLayerEnd = 0;

		for (int i = 0; i < layerEnd.length; i++) {
			totalLayerEnd += layerEnd[i];
		}

		bestAction = Math.random() * totalLayerEnd;

		if (bestAction <= layerEnd[0]) {
			bestAction = layerEnd[0];
		} else if (bestAction > layerEnd[0] && bestAction < layerEnd[1] + layerEnd[0]) {
			bestAction = layerEnd[1];
		} else if (bestAction > layerEnd[1] + layerEnd[0] && bestAction < layerEnd[2] + layerEnd[1] + layerEnd[0]) {
			bestAction = layerEnd[2];
		} else if (bestAction > layerEnd[2] + layerEnd[1] + layerEnd[0]
				&& bestAction < layerEnd[3] + layerEnd[2] + layerEnd[1] + layerEnd[0]) {
			bestAction = layerEnd[3];
		} else if (bestAction > layerEnd[3] + layerEnd[2] + layerEnd[1] + layerEnd[0]
				&& bestAction < layerEnd[4] + layerEnd[3] + layerEnd[2] + layerEnd[1] + layerEnd[0]) {
			bestAction = layerEnd[4];
		} else if (bestAction > layerEnd[4] + layerEnd[3] + layerEnd[2] + layerEnd[1] + layerEnd[0]
				&& bestAction < layerEnd[5] + layerEnd[4] + layerEnd[3] + layerEnd[2] + layerEnd[1] + layerEnd[0]) {
			bestAction = layerEnd[5];
		} else if (bestAction > layerEnd[5] + layerEnd[4] + layerEnd[3] + layerEnd[2] + layerEnd[1] + layerEnd[0]
				&& bestAction < layerEnd[6] + layerEnd[5] + layerEnd[4] + layerEnd[3] + layerEnd[2] + layerEnd[1]
						+ layerEnd[0]) {
			bestAction = layerEnd[6];
		} else if (bestAction > layerEnd[6] + layerEnd[5] + layerEnd[4] + layerEnd[3] + layerEnd[2] + layerEnd[1]
				+ layerEnd[0]
				&& bestAction < layerEnd[7] + layerEnd[6] + layerEnd[5] + layerEnd[4] + layerEnd[3] + layerEnd[2]
						+ layerEnd[1] + layerEnd[0]) {
			bestAction = layerEnd[7];
		} else if (bestAction > layerEnd[7] + layerEnd[6] + layerEnd[5] + layerEnd[4] + layerEnd[3] + layerEnd[2]
				+ layerEnd[1] + layerEnd[0]
				&& bestAction < layerEnd[8] + layerEnd[7] + layerEnd[6] + layerEnd[5] + layerEnd[4] + layerEnd[3]
						+ layerEnd[2] + layerEnd[1] + layerEnd[0]) {
			bestAction = layerEnd[8];
		} else if (bestAction > layerEnd[8] + layerEnd[7] + layerEnd[6] + layerEnd[5] + layerEnd[4] + layerEnd[3]
				+ layerEnd[2] + layerEnd[1] + layerEnd[0]) {
			bestAction = layerEnd[9];
		}

	}

	public void calculateOutput() {

		for (int i = 0; i < 5; i++) {
			layer1[i] = 0;
		}

		for (int i = 0; i < 5; i++) {
			layer2[i] = 0;
		}

		for (int i = 0; i < 5; i++) {
			layer3[i] = 0;
		}

		for (int i = 0; i < 8; i++) {
			layerEnd[i] = 0;
		}

		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < 13; a++)
				layer1[i] += inputBridge[a][i] * inputNum[a];
		}

		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < 5; a++)
				layer2[i] += bridge1[a][i] * layer1[a];
		}

		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < 5; a++)
				layer3[i] += bridge2[a][i] * layer2[a];
		}

		for (int i = 0; i < 8; i++) {
			for (int a = 0; a < 5; a++)
				layerEnd[i] += bridge3[a][i] * layer3[a];
		}

		switch (left) {
		case 1:
			if (gp.player1.atkC < 1) {
				calculateOutputH();
			} else {
				bestAction = largeNum10(layerEnd[0], layerEnd[1], layerEnd[2], layerEnd[3], layerEnd[4], layerEnd[5],
						layerEnd[6], layerEnd[7], layerEnd[8], layerEnd[9]);
			}
			break;

		case 2:
			if (gp.player2.atkC < 1) {
				calculateOutputH();
			} else {
				bestAction = largeNum10(layerEnd[0], layerEnd[1], layerEnd[2], layerEnd[3], layerEnd[4], layerEnd[5],
						layerEnd[6], layerEnd[7], layerEnd[8], layerEnd[9]);
			}
			break;
		}
		calculateOutputH();
	}

	public void calculateInput() {

		switch (gp.player1.name) {
		case "Otto":
			name1 = 0;
			break;
		case "Axel":
			name1 = 1;
			break;
		}

		switch (gp.player2.name) {
		case "Otto":
			name2 = 0;
			break;
		case "Axel":
			name2 = 1;
			break;
		}

		inputNum[0] = (double) left;

		inputNum[1] = (double) (gp.player1.hp / 1000);
		inputNum[2] = (double) (gp.player2.hp / 1000);

		inputNum[3] = (double) name1;
		inputNum[4] = (double) name2;

		inputNum[5] = (double) (gp.player1.atkC / 1000);
		inputNum[6] = (double) (gp.player2.atkC / 1000);

		inputNum[7] = (double) (gp.player1.x / 1000);
		inputNum[8] = (double) (1000 - (Math.abs(gp.player2.x - gp.player1.x))) / 1000;

		inputNum[9] = (double) (gp.player1.spriteType / 10);
		inputNum[10] = (double) (gp.player2.spriteType / 10);

		inputNum[11] = (double) (gp.player1.spriteNum / 10);
		inputNum[12] = (double) (gp.player1.spriteNum / 10);

	}

	public void outputDecider() {

		switch (left) {
		case 0:
			if (gp.player1.actionC == true) {
				if (bestAction == layerEnd[0]) {
					keyH.rightPressedL = true;
				} else if (bestAction == layerEnd[1]) {
					keyH.rightPressedL = false;
				} else if (bestAction == layerEnd[2]) {
					keyH.leftPressedL = true;
				} else if (bestAction == layerEnd[3]) {
					keyH.leftPressedL = false;
				}
				if (gp.player1.atkC <= 0) {
					if (bestAction == layerEnd[4]) {
						gp.player1.jab();
					} else if (bestAction == layerEnd[5]) {
						gp.player1.cross();
					} else if (bestAction == layerEnd[6]) {
						gp.player1.kick();
					} else if (bestAction == layerEnd[7]) {
						gp.player1.uppercut();
					} else if (bestAction == layerEnd[8]) {
						gp.player1.duck();
					} else if (bestAction == layerEnd[9]) {
						gp.player1.block();
					}
				}
			}
			break;
		case 1:
			if (gp.player2.actionC == true) {
				if (bestAction == layerEnd[0]) {
					keyH.leftPressedR = true;
				} else if (bestAction == layerEnd[1]) {
					keyH.leftPressedR = false;
				} else if (bestAction == layerEnd[2]) {
					keyH.rightPressedR = true;
				} else if (bestAction == layerEnd[3]) {
					keyH.rightPressedR = false;
				}
				if (gp.player2.atkC <= 0) {
					if (bestAction == layerEnd[4]) {
						gp.player2.jab();
					} else if (bestAction == layerEnd[5]) {
						gp.player2.cross();
					} else if (bestAction == layerEnd[6]) {
						gp.player2.kick();
					} else if (bestAction == layerEnd[7]) {
						gp.player2.uppercut();
					} else if (bestAction == layerEnd[8]) {
						gp.player2.duck();
					} else if (bestAction == layerEnd[9]) {
						gp.player2.block();
					}
				}
			}
			break;
		}

		if (keyH.leftPressedL == true) {
			gp.player1.walkBack();
		}
		if (keyH.rightPressedL == true) {
			gp.player1.walkForward();
		}

		if (keyH.leftPressedR == true) {
			gp.player2.walkForward();
		}
		if (keyH.rightPressedR == true) {
			gp.player2.walkBack();
		}

	}

	public void newGameChange() {
		gp.ai1.changeBridge();
		gp.ai2.changeBridge();
//		if (success >= 2) {
//			totalWinLoss--;
//		} else {
//			totalWinLoss++;
//		}
//		System.out.println(totalWinLoss);
//		success = 0;
	}

	public void update() {

		calculateInput();
		calculateOutput();
		outputDecider();

	}
}
