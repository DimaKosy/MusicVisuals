# Moby Duck: An Abstract Audio Visualiser

Video Demonstration:

[![YouTube](https://i.ytimg.com/vi/COJVn6kwEO0/maxresdefault.jpg?sqp=-oaymwEmCIAKENAF8quKqQMa8AEB-AH-CYAC0AWKAgwIABABGBEgcigxMA8=&rs=AOn4CLAHZKIKf9K6LVqRE-1SGsLdISzUow)](https://youtu.be/COJVn6kwEO0)

## Playback Instructions
- To start the visual demonstration: press the spacebar (space key) once
- To restart: press the spacebar again

*The scenes automatically changes during playback (see 'How It Works')*

## Project Members
- C21376161 Dmytro Kosynskyy
- C21344786 Shawn Lorenzo
- C21518659 Norbert Krupa
- C21427252 Darren Grants
- C21321073 Domas Mockus

# Description Of The Project

## Project Brief
- Create an abstract visual representation of a song of your choosing
- Visualise using Java Processing, Minim and/or Processing Sound libraries
- It should represent the chosen song's theme, narrative, mood, tempo and/or structure
- Showcase teamwork, creativity, technical skills and communication through tools such as GitHub for project management

## The Song: Moby Duck (The Longest Johns)

[![YouTube](https://i.ytimg.com/vi/xA7e_dxDOCo/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDuQlaJv-4ykUREOM2cqb-ALwUR2w)](https://youtu.be/xA7e_dxDOCo)

While I (Dmytro) was searching for a song for our project, I got confronted by a flock of ducks. They wouldn't scatter quickly enough so I waved my foot across them and scared them off!
Then I had an idea...

Sea shanties were always cool to me and one of the most memorable ones when I saw those ducks was this hit by The Longest Johns. It depicts a long-retired sailor, whose solitude was interrupted by a mythical, giant duck on his lake. He then goes to settle the score with the duck with the help of his ol' mates, and after a long, well-fought battle, they celebrated with a banquet of BBQed duck, pancakes and oyster sauce!

## Visual Representations

### Dmytro

![Duck Scale](images/j2.png)
I made two visuals for this project, one is a simple circle of rotating ducks which respond to the frequency bands. It is based off the cubes example shown in class.

```Java
for(int i = 0; i < DuckScaler.length; i++) {
		DuckScaler[i] = PApplet.map(mv.getSmoothedBands()[i],0,200,0.5f,3);
}
```

![Duck Battle](images/j4.png)
The second visual creates an array of points. These points go from right to left at a set pace, their height is set by the average frequency bands value which is then multiplied by a sin() function and lerped.

```Java
float BufferAvg() {
	float Avg;
	Avg = 0;
	for(int i = 0 ; i < mv.getBands().length ; i ++) {
		Avg += mv.getSmoothedBands()[i];
	}

	return (Avg/mv.getBands().length) *  0.3f;
}
```

```Java
if(p2 < p1) {
	points[(i + ((Move < 0)?0:1))%AmtPoints] = PApplet.lerp(points[(i + ((Move < 0)?1:0))%AmtPoints],(float)Math.sin(i*0.1)*ToLerp,0.5f);
	continue;
}
```

Each point is joined to the next point to make a wave like so:
```Java
mv.line(p1, points[i] + WaveHeight, p2, points[(i+1)%AmtPoints] + WaveHeight);
```
...which allows us to render a single wave.

By rendering multiple waves we can also call on the JoinWaveVerts() function.
This function joines the vertices of the waves so as to create triangles between them.

```Java
void JoinWaveVerts(Wave w1) {
	if(w1 == null) {
		return;
	}

	for(int i = 0; i < w1.AmtPoints; i++) {

		float p1 = ((float)(i)/AmtPoints)*WaveWidth;
		float p2 = (i < w1.AmtPoints)?(((float)(i+1)/AmtPoints)*WaveWidth):(p1);

		mv.line(p1, GrabWavePoint(p1), p1, w1.GrabWavePoint(p1));
		mv.line(p1, GrabWavePoint(p1)+2, p2, w1.GrabWavePoint(p2)-2);
	}
}
```

### Shawn

![Planning Chart](images/j3.png)
Taking inspiration from the general nautical theme of the song, I created a visual that represents how sailors would get their data on the high seas. It features 4 distinct elements:

- A background chart 'surface' to put the visual displays on
- A sonar wave with tuned amplitudes to cover certain frequency ranges
- A radar screen with an estimated location of ducks from the sonar
- A radio transmission set to check how the sailor's communications are holding

Audio data was being processed through the MyVisual/Visual class, which uses the Java Minim audio processing library. This was then modified to create certain wave amplitude behaviour for the sonar, such as:

``` Java
// Wave visualisation method (with scaling/lerp functions)
public void modWave(float scale)
{
	mv.pushStyle();
	mv.beginShape();

	for(int i = 0; i < mv.getAudioBuffer().size(); i++)
	{
		waveX = MyVisual.map(i, 0, mv.getAudioBuffer().size(), topX, topX+shapeW);
		waveY = MyVisual.map(mv.getAudioBuffer().get(i), -1, 1, -scale*shapeH, scale*shapeH);
		waveY = MyVisual.lerp(topY+shapeH/2, topY+shapeH/2+waveY, scale);
		waveY = MyVisual.constrain(waveY, topY, topY+shapeH);

		mv.smooth();
		mv.noFill();
		mv.stroke(255, 255, 0); // Change colour here
		mv.strokeWeight(4);
		mv.curveVertex(waveX, waveY);
	}

	mv.endShape();
	mv.popStyle();
}
```

...where 'scale' is a scaling factored applied to the lerped y-values for the AudioBuffer.

While the current positions of the displays are fixed for the project, they could be rearranged in any alignment through code similar to this:

``` Java
sonar1.screen(shapeW, (shapeH/2)-(shapeH/3), shapeW/2.5f, shapeH/6, 7, "Broadband Sonar", shapeH/42, "Hz", 0);
```

...where the final parameter '0' indicates that the display should be left-centre aligned to the chart.

It should be noted that the sailor from the song was likely from the 1800's, so he probably didn't have access to these tools to find pirates, let alone a giant duck!

### Norbert

![Lyric Wave](images/j1.png)
My visual is a wave of lyrics that changes height with the amplitude of the song. To make this, I used three classes:

### Darren

![Bubbles](images/j5.png)

### Domas

![Bars](images/j6.png)

# How It Works

## File Structure

## Audio-To-Visual Analysis

## Playback Control

# What We Are Most Proud Of

### Dmytro
### Shawn
### Norbert
### Darren
### Domas

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
