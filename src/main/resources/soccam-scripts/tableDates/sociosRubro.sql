USE [soccam]
GO
/****** Object:  Table [dbo].[sociosRubro]    Script Date: 12/06/2019 08:40:02 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sociosRubro](
	[sociosRubro_id] [bigint] IDENTITY(1,1) NOT NULL,
	[sociosRubro_nombre] [nvarchar](150) NULL,
	[sociosRubro_deleted] [bit] NULL,
	[sociosRubro_modificado] [datetime] NULL,
 CONSTRAINT [PK_sociosRubro] PRIMARY KEY CLUSTERED 
(
	[sociosRubro_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[sociosRubro] ON 

INSERT [dbo].[sociosRubro] ([sociosRubro_id], [sociosRubro_nombre], [sociosRubro_deleted], [sociosRubro_modificado]) VALUES (1, N'Comercios', 0, CAST(N'2017-10-21 22:49:01.177' AS DateTime))
INSERT [dbo].[sociosRubro] ([sociosRubro_id], [sociosRubro_nombre], [sociosRubro_deleted], [sociosRubro_modificado]) VALUES (2, N'Servicios', 0, CAST(N'2017-10-21 22:49:01.257' AS DateTime))
INSERT [dbo].[sociosRubro] ([sociosRubro_id], [sociosRubro_nombre], [sociosRubro_deleted], [sociosRubro_modificado]) VALUES (3, N'Industrias', 0, CAST(N'2017-10-21 22:49:01.423' AS DateTime))
SET IDENTITY_INSERT [dbo].[sociosRubro] OFF
