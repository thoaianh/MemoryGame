package model;

import java.awt.*;

import java.util.ArrayList;
import java.util.Random;

public class Matrix {
	private int row;
	private int col;
	private int matrixState[][];

	public Matrix(int m, int n) {
		this.row = m;
		this.col = n;
		init();
	}

	public void init() {
		createMatrix();
		showMatrix();
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void createMatrix() {
		matrixState = new int[row][col];
		Random rand = new Random();
		int imgCount = 4;
//        int max = 3;
//        int arr[] = new int[imgCount + 1];

		ArrayList<Point> listPoint = new ArrayList<Point>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				listPoint.add(new Point(i, j));
			}
		}
		int i = 0;
		while (i < row * col / 2) {
			int index = rand.nextInt(imgCount) + 1;

//            if (arr[index] < max) {
//                arr[index] += 2;
//                

			for (int j = 0; j < 2; j++) {
				int size = listPoint.size();
				int pointIndex = rand.nextInt(size);
				matrixState[listPoint.get(pointIndex).x][listPoint.get(pointIndex).y] = index;
				listPoint.remove(pointIndex);
			}
			i++;
		}
	}

	public void showMatrix() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.printf("%3d", matrixState[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * mỗi lần click vào button, hàm này đc chạy để lấy đánh dấu step validate với 2
	 * điều kiện sai: 1. khi click vào ảnh đã mở rồi =>> xem như chưa click step đó
	 * 2. khi click trùng 1 button ==> xem như chưa click step đó update lại state
	 */
     //click vào button
	public State calculate(State state, int x, int y) {
		if (matrixState[x][y] == -1) {
			return state;
		}
		
		state.setStep(state.getStep() + 1);
		if (state.getStep() == 1) {
			state.setStepOneX(x);
			state.setStepOneY(y);
			state.setImageStep1(matrixState[x][y]);
		}

		if (state.getStep() == 2 && x == state.getStepOneX() && y == state.getStepOneY()) {
			state.setStep(state.getStep() - 1);
			return state;
		}

		if (state.getStep() == 2) {
			state.setStepTwoX(x);
			state.setStepTwoY(y);
			state.setImageStep2(matrixState[x][y]);
			compare(state);
		}
		return state;
	}

	/*
	 * đủ 2 step click chọn hình sẽ chạy func này để compare ảnh, update lại kết quả
	 * so sánh ${result} và ảnh -1: ảnh nền đúng. 0: ảnh nền sai.
	 */
	public void compare(State state) {
		if (state.getImageStep1() == state.getImageStep2()) {
			matrixState[state.getStepOneX()][state
					.getStepOneY()] = matrixState[state.getStepTwoX()][state.getStepTwoY()] = -1;
			state.setResult(true);
			state.setCurrentScore(state.getCurrentScore() + 2);
			state.setIndex(-1);
		} else {
			state.setIndex(0);
			state.setResult(false);
		}
	}
}
