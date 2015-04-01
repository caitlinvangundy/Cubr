package mobileapps.cse5236.cubr;

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
        Square tempCurrentTopRow = currentFace.rows.get(0).squares.get(index);
        Square tempCurrentBottomRow = currentFace.rows.get(1).squares.get(index);
        if ("Down".equals(direction)) {
            currentFace.rows.get(0).squares.set(index, bottomFace.rows.get(0).squares.get(index));
            currentFace.rows.get(1).squares.set(index, bottomFace.rows.get(1).squares.get(index));

            bottomFace.rows.get(0).squares.set(index, backFace.rows.get(0).squares.get(index));
            bottomFace.rows.get(1).squares.set(index, backFace.rows.get(1).squares.get(index));

            backFace.rows.get(0).squares.set(index, topFace.rows.get(0).squares.get(index));
            backFace.rows.get(1).squares.set(index, topFace.rows.get(1).squares.get(index));

            topFace.rows.get(0).squares.set(index, tempCurrentTopRow);
            topFace.rows.get(1).squares.set(index, tempCurrentBottomRow);

            if(index == 0) {
                leftFace.rotateCounterClockwise();
            } else if(index == 1) {
                rightFace.rotateClockwise();
            }
        } else if ("Up".equals(direction)) {
            currentFace.rows.get(0).squares.set(index, topFace.rows.get(0).squares.get(index));
            currentFace.rows.get(1).squares.set(index, topFace.rows.get(1).squares.get(index));

            topFace.rows.get(0).squares.set(index, backFace.rows.get(0).squares.get(index));
            topFace.rows.get(1).squares.set(index, backFace.rows.get(1).squares.get(index));

            backFace.rows.get(0).squares.set(index, bottomFace.rows.get(0).squares.get(index));
            backFace.rows.get(1).squares.set(index, bottomFace.rows.get(1).squares.get(index));

            bottomFace.rows.get(0).squares.set(index, tempCurrentTopRow);
            bottomFace.rows.get(1).squares.set(index, tempCurrentBottomRow);

            if(index == 0) {
                leftFace.rotateClockwise();
            } else if(index == 1) {
                rightFace.rotateCounterClockwise();
            }
        }
    }

    public void rotateRow(int index, String direction) {
        Square tempCurrentLeft = currentFace.rows.get(index).squares.get(0);
        Square tempCurrentRight = currentFace.rows.get(index).squares.get(1);
        if ("Right".equals(direction)) {
            currentFace.rows.get(index).squares.set(0, leftFace.rows.get(index).squares.get(0));
            currentFace.rows.get(index).squares.set(1, leftFace.rows.get(index).squares.get(1));

            leftFace.rows.get(index).squares.set(0, backFace.rows.get(index).squares.get(0));
            leftFace.rows.get(index).squares.set(1, backFace.rows.get(index).squares.get(1));

            backFace.rows.get(index).squares.set(0, rightFace.rows.get(index).squares.get(0));
            backFace.rows.get(index).squares.set(1, rightFace.rows.get(index).squares.get(1));

            rightFace.rows.get(index).squares.set(0, tempCurrentLeft);
            rightFace.rows.get(index).squares.set(1, tempCurrentRight);

            if(index == 0) {
                topFace.rotateCounterClockwise();
            } else if(index == 1) {
                bottomFace.rotateClockwise();
            }
        } else if ("Left".equals(direction)) {
            currentFace.rows.get(index).squares.set(0, rightFace.rows.get(index).squares.get(0));
            currentFace.rows.get(index).squares.set(1, rightFace.rows.get(index).squares.get(1));

            rightFace.rows.get(index).squares.set(0, backFace.rows.get(index).squares.get(0));
            rightFace.rows.get(index).squares.set(1, backFace.rows.get(index).squares.get(1));

            backFace.rows.get(index).squares.set(0, leftFace.rows.get(index).squares.get(0));
            backFace.rows.get(index).squares.set(1, leftFace.rows.get(index).squares.get(1));

            leftFace.rows.get(index).squares.set(0, tempCurrentLeft);
            leftFace.rows.get(index).squares.set(1, tempCurrentRight);

            if(index == 0) {
                topFace.rotateClockwise();
            } else if(index == 1) {
                bottomFace.rotateCounterClockwise();
            }
        }
    }

    public void changeView(Face clickedFace) {
        Face tempCurrent = currentFace;
        switch (clickedFace.getType()) {
            case "Left":
                currentFace = leftFace;
                currentFace.faceIndex = 0;
                leftFace = backFace;
                leftFace.faceIndex = 3;
                backFace = rightFace;
                backFace.faceIndex = 2;
                rightFace = tempCurrent;
                rightFace.faceIndex = 1;
                topFace.rotateCounterClockwise();
                bottomFace.rotateClockwise();
                break;
            case "Right":
                currentFace = rightFace;
                currentFace.faceIndex = 0;
                rightFace = backFace;
                rightFace.faceIndex = 1;
                backFace = leftFace;
                backFace.faceIndex = 2;
                leftFace = tempCurrent;
                leftFace.faceIndex = 3;
                topFace.rotateClockwise();
                bottomFace.rotateCounterClockwise();
                break;
            case "Top":
                currentFace = topFace;
                currentFace.faceIndex = 0;
                topFace = backFace;
                topFace.faceIndex = 4;
                backFace = bottomFace;
                backFace.faceIndex = 2;
                bottomFace = tempCurrent;
                bottomFace.faceIndex = 5;
                leftFace.rotateClockwise();
                rightFace.rotateCounterClockwise();
                break;
            case "Bottom":
                currentFace = bottomFace;
                currentFace.faceIndex = 0;
                bottomFace = backFace;
                bottomFace.faceIndex = 5;
                backFace = topFace;
                backFace.faceIndex = 2;
                topFace = tempCurrent;
                topFace.faceIndex = 4;
                leftFace.rotateCounterClockwise();
                rightFace.rotateClockwise();
                break;
            default:
                System.out.println("Incorrect face");
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
