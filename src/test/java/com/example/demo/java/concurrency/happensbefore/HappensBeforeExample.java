package com.example.demo.java.concurrency.happensbefore;

public class HappensBeforeExample {

    public static class FrameExchanger  {

        private long framesStoredCount = 0;
        private long framesTakenCount  = 0;

        private volatile boolean hasNewFrame = false;

        private Frame frame = null;

        // called by Frame producing thread
        public void storeFrame(Frame frame) {
            this.frame = frame;
            this.framesStoredCount++;
            this.hasNewFrame = true;
        }
/**
        //imagine what would happen if the instructions were reordered, like this:
        public void storeFrame(Frame frame) {
            this.hasNewFrame = true;
            this.framesStoredCount++;
            this.frame = frame;
        }
        //This reordering doesn't affect the execution of this code in isolation (== "it obeys intra-thread semantics")
        //however, it is obvious that it breaks the code semantics when run in multithreaded environment:
        //The field hasNewFrame is now set to true before the frame field is assigned to reference the new Frame object.
        //Volatile keyword in this example guarantees that all writes to frame and framesStoredCount variable
        //"happens-before" a write to hasNewFrame variable. Also, when the hasNewFrame variable is set to true,
        //the frame and frameStoredCount will also be synchronized to main memory.
*/

        // called by Frame drawing thread
        public Frame takeFrame() {
            while( !hasNewFrame) {
                //busy wait until new frame arrives
            }

            Frame newFrame = this.frame;
            this.framesTakenCount++;
            this.hasNewFrame = false;
            return newFrame;
        }

    }

    public static class Frame {
    }
}
