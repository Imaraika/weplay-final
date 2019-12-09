package com.example.weplay;

class PlaygroundData {
    private String playgroundName;
    private String playgroundDescription;
    private int playgroundImage;

    public PlaygroundData(String playgroundName, String playgroundDescription, int playgroundImage) {
        this.playgroundName = playgroundName;
        this.playgroundDescription = playgroundDescription;
        this.playgroundImage = playgroundImage;
    }

    public String getPlaygroundName() {
        return playgroundName;
    }

    public String getPlaygroundDescription() {
        return playgroundDescription;
    }

    public int getPlaygroundImage() {
        return playgroundImage;
    }
}

