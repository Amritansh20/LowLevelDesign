package SnakeAndLadder;

public class Player {
        String id;
        int currentPosition;

        Player(String id, int currentPosition){
            this.id=id;
            this.currentPosition=currentPosition;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setCurrentPosition(int currentPosition) {
            this.currentPosition = currentPosition;
        }

        public int getCurrentPosition() {
            return currentPosition;
        }
}
