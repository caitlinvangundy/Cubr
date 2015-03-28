package mobileapps.cse5236.cubr;

import android.view.View;

/**
 * Created by Caitlin on 3/24/2015.
 */
public class CubeView {
    private Face currentFace;
    private Face backFace;
    private Face leftFace;
    private Face rightFace;
    private Face bottomFace;
    private Face topFace;

    public CubeView() {
        currentFace = new Face(0);
        rightFace = new Face(1);
        backFace = new Face(2);
        leftFace = new Face(3);
        topFace = new Face(4);
        bottomFace = new Face(5);
    }

    public void rotateColumn(int index, String direction) {
        Column tempCurrent = currentFace.columns.get(index);
        if ("Up".equals(direction)) {
            // TODO What about the left and right faces?
            currentFace.columns.set(index, bottomFace.columns.get(index));
            bottomFace.columns.set(index, backFace.columns.get(index));
            backFace.columns.set(index, topFace.columns.get(index));
            topFace.columns.set(index, tempCurrent);
        } else if ("Down".equals(direction)) {
            currentFace.columns.set(index, topFace.columns.get(index));
            topFace.columns.set(index, backFace.columns.get(index));
            backFace.columns.set(index, bottomFace.columns.get(index));
            bottomFace.columns.set(index, tempCurrent);
        }
    }

    public void rotateRow(int index, String direction) {
        Column tempCurrent = currentFace.columns.get(index);
        if ("Left".equals(direction)) {
            // TODO What about the top and bottom faces?
            currentFace.columns.set(index, leftFace.columns.get(index));
            leftFace.columns.set(index, backFace.columns.get(index));
            backFace.columns.set(index, rightFace.columns.get(index));
            rightFace.columns.set(index, tempCurrent);
        } else if ("Right".equals(direction)) {
            currentFace.columns.set(index, rightFace.columns.get(index));
            rightFace.columns.set(index, backFace.columns.get(index));
            backFace.columns.set(index, leftFace.columns.get(index));
            leftFace.columns.set(index, tempCurrent);
        }
    }

    public void changeView(Face clickedFace) {
        Face tempCurrent = currentFace;
        switch (clickedFace.getType()) {
            // TODO Might be missing logic to flip faces
            case "Left":
                currentFace = leftFace;
                leftFace = backFace;
                backFace = rightFace;
                rightFace = tempCurrent;
                topFace.rotateCounterClockwise();
                bottomFace.rotateCounterClockwise();
                break;
            case "Right":
                currentFace = rightFace;
                rightFace = backFace;
                backFace = leftFace;
                leftFace = tempCurrent;
                topFace.rotateClockwise();
                bottomFace.rotateClockwise();
                break;
            case "Top":
                currentFace = topFace;
                topFace = backFace;
                backFace = bottomFace;
                bottomFace = tempCurrent;
                leftFace.rotateClockwise();
                rightFace.rotateCounterClockwise();
                break;
            case "Bottom":
                currentFace = bottomFace;
                bottomFace = backFace;
                backFace = topFace;
                topFace = tempCurrent;
                leftFace.rotateCounterClockwise();
                rightFace.rotateClockwise();
                break;
        }
    }

    public Face getCurrentFace() {
        return currentFace;
    }

    public Face getTopFace() {
        return topFace;
    }

    public Face getLeftFace() {
        return leftFace;
    }

    public Face getBottomFace() {
        return bottomFace;
    }

    public Face getRightFace() {
        return rightFace;
    }

    public Face getBackFace() {
        return backFace;
    }
}
