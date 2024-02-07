interface TV{
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int v);
    int getChannel();
    void setChannel(int c);
}

class SmartTV implements TV{
    boolean powerOn=false;
    int volume = 0;
    int channel = 0;
    
    @Override
    public boolean isEnabled() {
        return powerOn;
    }
    
    @Override
    public void enable() { powerOn=true; }

    @Override
    public void disable() { powerOn=false; }

    @Override
    public int getVolume() { return volume; }

    @Override
    public void setVolume(int vol) { volume = vol; }

    @Override
    public int getChannel() { return channel; }

    @Override
    public void setChannel(int c) { this.channel = c; }
    
    public void Youtube(){
        System.out.println("Youtube is running...");
    }
}

class GeneralTV implements TV{
    boolean powerOn=false;
    int volume = 0;
    int channel = 0;

    @Override
    public boolean isEnabled() { return powerOn; }
    @Override
    public void enable() { powerOn=true; }
    @Override
    public void disable() { powerOn=false; }
    @Override
    public int getVolume() { return volume; }
    @Override
    public void setVolume(int vol) { volume=vol; }
    @Override
    public int getChannel() { return channel; }
    @Override
    public void setChannel(int channel) { this.channel=channel; }
}


class Remote{
    protected TV tv;
    Remote(){ tv=null; }
    Remote(TV tv){ this.tv=tv; }
    public void togglePower() {
        if(tv.isEnabled()){
            tv.disable();
            System.out.println("Power  off");
        }
        else {
            tv.enable();
            System.out.println("Power on");
        }
    }

    public void volumeUp() {
        if(tv.isEnabled()) {
            tv.setVolume(tv.getVolume()+5);
            System.out.println("Increase volume ");
        } else {
            System.out.println("power off");
        }
    }

    public void volumeDown() {
        if(tv.isEnabled()){
            tv.setVolume(tv.getVolume()-5);
            System.out.println("Decreas volume ");
        } else{
            System.out.println("power off");
        }

    }

    public void channelUp() {
        if(tv.isEnabled()){
            tv.setChannel(tv.getVolume()+1);
            System.out.println("Channel change ");
        } else {
            System.out.println("power off");
        }


    }

    public void channelDown() {
        if(tv.isEnabled()) {
            tv.setChannel(tv.getVolume()-1);
            System.out.println("Channel  change ");
        }else {
            System.out.println("power off");
        }

    }
}

class SmartRemote extends Remote {
    SmartRemote(){ } 
    SmartRemote(TV tv){ super(tv); }
    void showYoutube(){ ((SmartTV)tv).Youtube(); }
}

public class Main {
    public static void main(String[] args) {

        GeneralTV gtv = new GeneralTV();
        SmartTV stv = new SmartTV();
        Remote remote = new Remote(gtv);
        SmartRemote sremote = new SmartRemote(stv);
        sremote.togglePower();
        sremote.volumeUp();
        sremote.channelUp();
        sremote.channelDown();
        sremote.volumeDown();
        sremote.showYoutube();
        

    }

}