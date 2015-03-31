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
        if ("Up".equals(direction)) {
            currentFace.rows.get(0).squares.set(index, bottomFace.rows.get(0).squares.get(index));
            currentFace.rows.get(1).squares.set(index, bottomFace.rows.get(1).squares.get(index));

            bottomFace.rows.get(0).squares.set(index, backFace.rows.get(0).squares.get(index));
            bottomFace.rows.get(1).squares.set(index, backFace.rows.get(1).squares.get(index));

            backFace.rows.get(0).squares.set(index, topFace.rows.get(0).squares.get(index));
            backFace.rows.get(1).squares.set(index, topFace.rows.get(1).squares.get(index));

            topFace.rows.get(0).squares.set(index, tempCurrentTopRow);
            topFace.rows.get(1).squares.set(index, tempCurrentBottomRow);
        } else if ("Down".equals(direction)) {
            currentFace.rows.get(0).squares.set(index, topFace.rows.get(0).squares.get(index));
            currentFace.rows.get(1).squares.set(index, topFace.rows.get(1).squares.get(index));

            topFace.rows.get(0).squares.set(index, backFace.rows.get(0).squares.get(index));
            topFace.rows.get(1).squares.set(index, backFace.rows.get(1).squares.get(index));

            backFace.rows.get(0).squares.set(index, bottomFace.rows.get(0).squares.get(index));
            backFace.rows.get(1).squares.set(index, bottomFace.rows.get(1).squares.get(index));

            bottomFace.rows.get(0).squares.set(index, tempCurrentTopRow);
            bottomFace.rows.get(1).squares.set(index, tempCurrentBottomRow);
        }
    }

    public void rotateRow(int index, String direction) {
        Row tempCurrent = currentFace.rows.get(index);
        if ("Right".equals(direction)) {
            // TODO What about the top and bottom faces?
            currentFace.rows.set(index, leftFace.rows.get(index));
            leftFace.rows.set(index, backFace.rows.get(index));
            backFace.rows.set(index, rightFace.rows.get(index));
            rightFace.rows.set(index, tempCurrent);
        } else if ("Left".equals(direction)) {
            currentFace.rows.set(index, rightFace.rows.get(index));
            rightFace.rows.set(index, backFace.rows.get(index));
            backFace.rows.set(index, leftFace.rows.get(index));
            leftFace.rows.set(index, tempCurrent);
        }
    }

    public void changeView(Face clickedFace) {
        Face tempCurrent = currentFace;
        switch (clickedFace.getType()) {
            // TODO Might be missing logic to flip faces
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
