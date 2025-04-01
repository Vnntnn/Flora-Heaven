package main.controller.common.Ending;

import main.model.Gameplay.StoryHandler;
import main.view.Gamewindow.Ending.EndingView;
import java.util.HashMap;
import java.util.Map;


public class CustomStoryHandler implements StoryHandler {
    @Override
    public Map<String, EndingView.StoryLabelInfo> createStoryContent() {
        Map<String, EndingView.StoryLabelInfo> labelInfos = new HashMap<>();
        int width = 1290;

        // Title
        labelInfos.put("title", new EndingView.StoryLabelInfo(
                "Ending", 80f, 515, 18, width, 200));

        // Story content
        labelInfos.put("story1", new EndingView.StoryLabelInfo(
                "เสียงกระซิบดังขึ้นจากทุกมุมของร้าน รากไม้เริ่มขยับ กลิ่นหอมเปลี่ยนเป็นกลิ่นดินชื้น",
                18f, 150, 150, width, 200));

        labelInfos.put("story2", new EndingView.StoryLabelInfo(
                "และเลือดจาง ๆ คุณจ้องมองจดหมายฉบับสุดท้าย ความทรงจำที่ถูกลืมค่อยๆย้อนกลับมา",
                18f, 80, 200, width, 200));

        labelInfos.put("story3", new EndingView.StoryLabelInfo(
                "คุณไม่ใช่แค่เจ้าของร้านต้นไม้ คุณคือหนึ่งในนักวิจัยของโครงการ Flora Heaven",
                18f, 80, 260, width, 200));

        labelInfos.put("story4", new EndingView.StoryLabelInfo(
                "และลูกค้าของคุณ คือ เหยื่อที่รอดชีวิตจากมัน",
                18f, 80, 310, width, 200));

        labelInfos.put("story5", new EndingView.StoryLabelInfo(
                "หญิงชราลึกลับไม่ได้เป็นเพียงลูกค้าคนสุดท้าย แต่คือตัวคุณเอง เงาที่คุณหลบหนีมาตลอด",
                18f, 80, 370, width, 200));

        labelInfos.put("story6", new EndingView.StoryLabelInfo(
                "คุณจำได้แล้วว่าเคยจากที่ไหนมาและรู้ว่าถึงเวลาต้องเลือก จะอยู่ต่อ หรือ กลับไปเผชิญความจริง?",
                18f, 80, 420, width, 200));

        // Ending tag
        labelInfos.put("ending", new EndingView.StoryLabelInfo(
                "ENDING (?): ความทรงจำที่ถูกฝัง",
                25f, 430, 500, width, 200));

        // Notes (positioned on the right side)
        labelInfos.put("note1", new EndingView.StoryLabelInfo(
                "เราทุกคนกำลังรอเจ้าอยู่…",
                15f, 1000, 220, width, 200));

        labelInfos.put("note2", new EndingView.StoryLabelInfo(
                "กลับมาเถิด",
                15f, 1050, 260, width, 200));

        return labelInfos;
    }
}