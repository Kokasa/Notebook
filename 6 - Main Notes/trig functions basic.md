2025-03-05    21:38

tags: [[Math]]


# trig functions

明白了！以下是重新整理后的内容，所有公式均用 `$` 包裹：

---

### **第二章：三角函数与弧度制**
1. **弧度（Radians）**:  
   - **定义**:  
     弧度是基于单位圆的**弧长**来度量角度。  
     - $1$ 弧度 = 单位圆上弧长等于半径时所对应的角度。  
     - 一个完整圆周 = $2\pi$ 弧度（而非 $360^\circ$）。  
   - **为何用弧度？**  
     - 微积分中三角函数的导数/积分公式仅在弧度下成立（例如 $\frac{d}{dx} \sin x = \cos x$）。  
     - 弧长公式 $s = r\theta$（$\theta$ 为弧度）。  

2. **单位圆（Unit Circle）**:  
   - 半径 $1$ 的圆，中心在原点 $(0,0)$。  
   - 单位圆上任意点的坐标为 $(\cos \theta, \sin \theta)$，其中 $\theta$ 是从 $x$ 轴正方向逆时针旋转的角度。  
   - **关键角度记忆**:  
     - $0, \frac{\pi}{6}, \frac{\pi}{4}, \frac{\pi}{3}, \frac{\pi}{2}, \pi, \frac{3\pi}{2}, 2\pi$。  
     - 例如：$\frac{\pi}{4}$ 对应坐标 $\left( \frac{\sqrt{2}}{2}, \frac{\sqrt{2}}{2} \right)$。  

3. **三角函数定义**:  
   - 基本函数：  
     - $\sin \theta = y\text{-坐标}$，  
     - $\cos \theta = x\text{-坐标}$，  
     - $\tan \theta = \frac{\sin \theta}{\cos \theta}$。  
   - 倒数函数：  
     - $\csc \theta = \frac{1}{\sin \theta}$，  
     - $\sec \theta = \frac{1}{\cos \theta}$，  
     - $\cot \theta = \frac{1}{\tan \theta}$。  

4. **三角函数的对称性**:  
   - **偶函数**：$\cos(-\theta) = \cos \theta$。  
   - **奇函数**：$\sin(-\theta) = -\sin \theta$，$\tan(-\theta) = -\tan \theta$。  

5. **常用恒等式**:  
   - 毕达哥拉斯恒等式：$\sin^2 \theta + \cos^2 \theta = 1$。  
   - 和角公式：  
     - $\sin(a \pm b) = \sin a \cos b \pm \cos a \sin b$，  
     - $\cos(a \pm b) = \cos a \cos b \mp \sin a \sin b$。  

---

### **微积分中的重要性**
- **导数规则（需弧度制）**:  
  - $\frac{d}{dx} \sin x = \cos x$，  
  - $\frac{d}{dx} \cos x = -\sin x$，  
  - $\frac{d}{dx} \tan x = \sec^2 x$。  

- **积分规则**:  
  - $\int \sin x \, dx = -\cos x + C$，  
  - $\int \cos x \, dx = \sin x + C$。  

---

### **练习建议**
1. **单位圆记忆**: 手绘单位圆并标注主要角度（如 $\frac{\pi}{6}, \frac{\pi}{4}, \frac{\pi}{3}$）及其坐标。  
2. **角度转换**:  
   - $30^\circ = \frac{\pi}{6}$，  
   - $45^\circ = \frac{\pi}{4}$，  
   - $180^\circ = \pi$。  
3. **验证恒等式**: 用 $\sin^2 \theta + \cos^2 \theta = 1$ 推导 $\tan^2 \theta + 1 = \sec^2 \theta$。  

---

单位圆和弧度制是微积分中分析周期性现象（如波动、旋转运动）的基础工具。熟练掌握后，后续学习微分方程和傅里叶分析会更轻松！ 📐✨

# References
