USE [soccam]
GO
/****** Object:  Table [dbo].[tipoSocio]    Script Date: 12/06/2019 08:54:51 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tipoSocio](
	[tipoSocio_id] [bigint] IDENTITY(1,1) NOT NULL,
	[tipoSocio_tipo] [int] NULL,
	[tipoSocio_nombre] [nvarchar](150) NULL,
	[tipoSocio_importe] [decimal](25, 13) NULL,
	[tipoSocio_periodicidad] [int] NULL,
	[tipoSocio_deleted] [bit] NULL,
	[tipoSocio_modificado] [datetime] NULL,
	[tipoSocio_categoria] [char](1) NULL,
 CONSTRAINT [PK_tipoSocio] PRIMARY KEY CLUSTERED 
(
	[tipoSocio_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tipoSocio] ON 

INSERT [dbo].[tipoSocio] ([tipoSocio_id], [tipoSocio_tipo], [tipoSocio_nombre], [tipoSocio_importe], [tipoSocio_periodicidad], [tipoSocio_deleted], [tipoSocio_modificado], [tipoSocio_categoria]) VALUES (1, 0, N'Activo General', CAST(130.0000000000000 AS Decimal(25, 13)), 0, 0, CAST(N'2018-06-21 14:08:23.377' AS DateTime), NULL)
INSERT [dbo].[tipoSocio] ([tipoSocio_id], [tipoSocio_tipo], [tipoSocio_nombre], [tipoSocio_importe], [tipoSocio_periodicidad], [tipoSocio_deleted], [tipoSocio_modificado], [tipoSocio_categoria]) VALUES (2, 0, N'Protector General', CAST(130.0000000000000 AS Decimal(25, 13)), 0, 0, CAST(N'2018-06-21 14:09:05.893' AS DateTime), NULL)
INSERT [dbo].[tipoSocio] ([tipoSocio_id], [tipoSocio_tipo], [tipoSocio_nombre], [tipoSocio_importe], [tipoSocio_periodicidad], [tipoSocio_deleted], [tipoSocio_modificado], [tipoSocio_categoria]) VALUES (10002, 0, N'Protector (Estudios Contables)', CAST(130.0000000000000 AS Decimal(25, 13)), 0, 0, CAST(N'2018-06-21 14:09:14.747' AS DateTime), NULL)
INSERT [dbo].[tipoSocio] ([tipoSocio_id], [tipoSocio_tipo], [tipoSocio_nombre], [tipoSocio_importe], [tipoSocio_periodicidad], [tipoSocio_deleted], [tipoSocio_modificado], [tipoSocio_categoria]) VALUES (10003, 0, N'Estudios Contables', CAST(100.0000000000000 AS Decimal(25, 13)), 0, 1, CAST(N'2015-12-11 10:14:29.623' AS DateTime), NULL)
INSERT [dbo].[tipoSocio] ([tipoSocio_id], [tipoSocio_tipo], [tipoSocio_nombre], [tipoSocio_importe], [tipoSocio_periodicidad], [tipoSocio_deleted], [tipoSocio_modificado], [tipoSocio_categoria]) VALUES (10004, 0, N'Protector (Bancos)', CAST(150.0000000000000 AS Decimal(25, 13)), 0, 0, CAST(N'2015-12-21 16:11:57.177' AS DateTime), NULL)
INSERT [dbo].[tipoSocio] ([tipoSocio_id], [tipoSocio_tipo], [tipoSocio_nombre], [tipoSocio_importe], [tipoSocio_periodicidad], [tipoSocio_deleted], [tipoSocio_modificado], [tipoSocio_categoria]) VALUES (20002, 0, N'Protector (Jubilado)', CAST(130.0000000000000 AS Decimal(25, 13)), 0, 0, CAST(N'2018-06-21 14:09:30.497' AS DateTime), NULL)
INSERT [dbo].[tipoSocio] ([tipoSocio_id], [tipoSocio_tipo], [tipoSocio_nombre], [tipoSocio_importe], [tipoSocio_periodicidad], [tipoSocio_deleted], [tipoSocio_modificado], [tipoSocio_categoria]) VALUES (20003, 0, N'Socio Honorario', CAST(0.0000000000000 AS Decimal(25, 13)), 0, 0, CAST(N'2018-06-04 11:35:42.713' AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[tipoSocio] OFF
