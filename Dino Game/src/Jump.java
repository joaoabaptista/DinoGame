public class Jump {

    private int maxHeight;
    private Dino dino;
    private int speed;
    private boolean jumping;

    public Jump(Dino dino) {
        this.dino = dino;
        this.maxHeight = 50;
        this.speed = -18;
        this.jumping = false;
    }

    public void startJump() {
        if (!jumping) {
            jumping = true;
            Thread jumpThread = new Thread(() -> {
                int initialY = dino.getY();
                int velocity = speed;

                while(jumping) {
                    dino.setY(dino.getY() + velocity);
                    velocity += 1;

                    if (dino.getY() >= initialY) {
                        dino.setY(initialY);
                        jumping = false;
                    }

                    try{
                        Thread.sleep(20);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            jumpThread.start();
        }
    }
    public boolean isJumping() {
        return jumping;
    }
}
