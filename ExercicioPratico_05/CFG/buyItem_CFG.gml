Creator	"yFiles"
Version	"2.15"
graph
[
	hierarchic	1
	label	""
	directed	1
	node
	[
		id	0
		label	"Entry"
		graphics
		[
			x	147.0977872455374
			y	-40.58675441766357
			w	80.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.terminator"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"Entry"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	node
	[
		id	1
		label	"t = 0"
		graphics
		[
			x	335.9885657548198
			y	-40.58675441766357
			w	80.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.terminator"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#FF0000"
		]
		LabelGraphics
		[
			text	"t = 0"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	node
	[
		id	2
		label	"newc = 0.0"
		graphics
		[
			x	335.9885657548198
			y	61.48061548861665
			w	80.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.terminator"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#FF0000"
		]
		LabelGraphics
		[
			text	"newc = 0.0"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	node
	[
		id	3
		label	"n > 0"
		graphics
		[
			x	335.9885657548198
			y	163.54798539489687
			w	80.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.decision"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#0000FF"
		]
		LabelGraphics
		[
			text	"n > 0"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	node
	[
		id	4
		label	"t = n * PRICE"
		graphics
		[
			x	208.98856575481977
			y	276.04798539489684
			w	91.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.terminator"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#FF0000"
		]
		LabelGraphics
		[
			text	"t = n * PRICE"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	node
	[
		id	5
		label	"newc = c"
		graphics
		[
			x	445.4885657548198
			y	276.04798539489684
			w	80.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.terminator"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#FF0000"
		]
		LabelGraphics
		[
			text	"newc = c"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	node
	[
		id	6
		label	"t <= c"
		graphics
		[
			x	208.98856575481977
			y	361.04798539489684
			w	80.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.decision"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#0000FF"
		]
		LabelGraphics
		[
			text	"t <= c"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	node
	[
		id	7
		label	"newc = c - t"
		graphics
		[
			x	87.34939938749551
			y	548.5479853948968
			w	80.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.terminator"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#FF0000"
		]
		LabelGraphics
		[
			text	"newc = c - t"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	node
	[
		id	8
		label	"return newc"
		graphics
		[
			x	335.9885657548198
			y	548.5479853948968
			w	80.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.terminator"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#FF0000"
		]
		LabelGraphics
		[
			text	"return newc"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	node
	[
		id	9
		label	"Exit"
		graphics
		[
			x	699.2067132146749
			y	548.5479853948968
			w	80.0
			h	40.0
			customconfiguration	"com.yworks.flowchart.terminator"
			fill	"#E8EEF7"
			fill2	"#B7C9E3"
			outline	"#000000"
		]
		LabelGraphics
		[
			text	"Exit"
			fontSize	12
			fontName	"Dialog"
			anchor	"c"
		]
	]
	edge
	[
		source	0
		target	1
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
		]
	]
	edge
	[
		source	1
		target	2
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
		]
	]
	edge
	[
		source	2
		target	3
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
			Line
			[
				point
				[
					x	335.9885657548198
					y	61.48061548861665
				]
				point
				[
					x	335.9885657548198
					y	143.54798539489687
				]
				point
				[
					x	335.9885657548198
					y	163.54798539489687
				]
			]
		]
	]
	edge
	[
		source	3
		target	4
		label	"True"
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
		]
		LabelGraphics
		[
			text	"True"
			fontSize	12
			fontName	"Dialog"
			configuration	"AutoFlippingLabel"
			contentWidth	31.251953125
			contentHeight	17.96875
			underlineText	1
			model	"six_pos"
			position	"tail"
		]
	]
	edge
	[
		source	3
		target	5
		label	"False"
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
		]
		LabelGraphics
		[
			text	"False"
			fontSize	12
			fontName	"Dialog"
			configuration	"AutoFlippingLabel"
			contentWidth	35.224609375
			contentHeight	17.96875
			underlineText	1
			model	"six_pos"
			position	"tail"
		]
	]
	edge
	[
		source	4
		target	6
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
		]
	]
	edge
	[
		source	6
		target	7
		label	"True"
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
		]
		LabelGraphics
		[
			text	"True"
			fontSize	12
			fontName	"Dialog"
			configuration	"AutoFlippingLabel"
			contentWidth	31.251953125
			contentHeight	17.96875
			underlineText	1
			model	"six_pos"
			position	"tail"
		]
	]
	edge
	[
		source	7
		target	8
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
		]
	]
	edge
	[
		source	5
		target	8
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
			Line
			[
				point
				[
					x	445.4885657548198
					y	276.04798539489684
				]
				point
				[
					x	522.7796889604317
					y	368.7952528155257
				]
				point
				[
					x	522.7796889604317
					y	368.7952528155257
				]
				point
				[
					x	335.9885657548198
					y	548.5479853948968
				]
			]
		]
	]
	edge
	[
		source	6
		target	8
		label	"False"
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
		]
		LabelGraphics
		[
			text	"False"
			fontSize	12
			fontName	"Dialog"
			configuration	"AutoFlippingLabel"
			contentWidth	35.224609375
			contentHeight	17.96875
			underlineText	1
			model	"six_pos"
			position	"tail"
		]
	]
	edge
	[
		source	8
		target	9
		graphics
		[
			fill	"#000000"
			targetArrow	"standard"
		]
	]
]
