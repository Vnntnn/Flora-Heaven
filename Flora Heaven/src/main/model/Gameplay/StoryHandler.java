package main.model.Gameplay;

import main.view.Gamewindow.Ending.EndingView;
import java.util.Map;

public interface StoryHandler {
    Map<String, EndingView.StoryLabelInfo> createStoryContent();
}