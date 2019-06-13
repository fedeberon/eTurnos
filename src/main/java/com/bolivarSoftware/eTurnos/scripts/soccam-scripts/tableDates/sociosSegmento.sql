USE [soccam]
GO
/****** Object:  Table [dbo].[sociosSegmento]    Script Date: 12/06/2019 08:34:32 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sociosSegmento](
	[sociosSegmento_id] [bigint] IDENTITY(1,1) NOT NULL,
	[sociosSegmento_rubro] [bigint] NULL,
	[sociosSegmento_nombre] [nvarchar](150) NULL,
	[sociosSegmento_deleted] [bit] NULL,
	[sociosSegmento_modificado] [datetime] NULL,
 CONSTRAINT [PK_sociosSegmento] PRIMARY KEY CLUSTERED 
(
	[sociosSegmento_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[sociosSegmento] ON 

INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (1, 1, N'Indumentaria y Calzado', 0, CAST(N'2017-10-21 22:49:01.193' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (2, 1, N'Implementos Agricolas', 0, CAST(N'2017-10-21 22:49:01.213' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (3, 1, N'Alimentos y Bebidas', 0, CAST(N'2017-10-21 22:49:01.220' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (4, 1, N'Art. Del Hogar', 0, CAST(N'2017-10-21 22:49:01.230' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (5, 1, N'Pinturerias y/o Ferreterias', 0, CAST(N'2017-10-21 22:49:01.243' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (6, 2, N'Talleres Mecanicos y Otros', 0, CAST(N'2017-10-21 22:49:01.257' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (7, 1, N'Distribuidores y/o Mayoristas', 0, CAST(N'2017-10-21 22:49:01.270' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (8, 2, N'Servicios Públicos', 0, CAST(N'2017-10-21 22:49:01.290' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (9, 2, N'Medios de Comunicación', 0, CAST(N'2017-10-21 22:49:01.307' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (10, 2, N'Estacionamientos', 0, CAST(N'2017-10-21 22:49:01.317' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (11, 1, N'Insumos Agricola Ganaderos', 0, CAST(N'2017-10-21 22:49:01.330' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (12, 2, N'Contadores y Gestores', 0, CAST(N'2017-10-21 22:49:01.340' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (13, 2, N'Servicios Agropecuarios', 0, CAST(N'2017-10-21 22:49:01.363' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (14, 1, N'Construcción', 0, CAST(N'2017-10-21 22:49:01.397' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (15, 2, N'Seguros', 0, CAST(N'2017-10-21 22:49:01.413' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (16, 3, N'Productores de Alimentos', 0, CAST(N'2017-10-21 22:49:01.430' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (17, 1, N'Gastronomia', 0, CAST(N'2017-10-21 22:49:01.473' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (18, 3, N'Panaderias', 0, CAST(N'2017-10-21 22:49:01.480' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (19, 1, N'Librerías e Imprentas', 0, CAST(N'2017-10-21 22:49:01.490' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (20, 3, N'Carpinterias', 0, CAST(N'2017-10-21 22:49:01.497' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (21, 2, N'Servicios de Mant. Y Rep.', 0, CAST(N'2017-10-21 22:49:01.510' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (22, 1, N'Art. Limipieza e Higiene', 0, CAST(N'2017-10-21 22:49:01.520' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (23, 1, N'Kioskos y Polirubros', 0, CAST(N'2017-10-21 22:49:01.527' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (24, 1, N'Veterinarias', 0, CAST(N'2017-10-21 22:49:01.540' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (25, 2, N'Servicios Médicos', 0, CAST(N'2017-10-21 22:49:01.550' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (26, 2, N'Entidades Financieras', 0, CAST(N'2017-10-21 22:49:01.557' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (27, 3, N'Industria Plástica', 0, CAST(N'2017-10-21 22:49:01.687' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (28, 1, N'Combustibles y Lubricantes', 0, CAST(N'2017-10-21 22:49:01.690' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (29, 2, N'Otros', 0, CAST(N'2017-10-21 22:49:01.717' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (30, 1, N'Farmacias y Perfumerias', 0, CAST(N'2017-10-21 22:49:01.733' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (31, 1, N'Hoteles', 0, CAST(N'2017-10-21 22:49:01.780' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (32, 2, N'Prod. Agropecuario', 0, CAST(N'2017-10-21 22:49:01.787' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (33, 1, N'Tecnología y Computación', 0, CAST(N'2017-10-21 22:49:01.797' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (34, 2, N'Instituciones', 0, CAST(N'2017-10-21 22:49:01.873' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (35, 1, N'Art. Electricidad', 0, CAST(N'2017-10-21 22:49:01.890' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (36, 1, N'Concecionarias de Automotriz', 0, CAST(N'2017-10-21 22:49:01.903' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (37, 2, N'Abogados y Escribanos', 0, CAST(N'2017-10-21 22:49:01.917' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (38, 2, N'Arquitectos', 0, CAST(N'2017-10-21 22:49:01.923' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (39, 2, N'Servicios de Transporte', 0, CAST(N'2017-10-21 22:49:01.930' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (40, 2, N'Servicios Inmobiliarios', 0, CAST(N'2017-10-21 22:49:02.060' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (41, 2, N'Turismo', 0, CAST(N'2017-10-21 22:49:02.127' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (42, 1, N'Mercerias', 0, CAST(N'2017-10-21 22:49:02.243' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (43, 2, N'Eventos', 0, CAST(N'2017-10-21 22:49:02.307' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (44, 1, N'Opticas', 0, CAST(N'2017-10-21 22:49:02.493' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (45, 2, N'Clubes Deportivos y Gimnasios', 0, CAST(N'2017-10-21 22:49:02.580' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (46, 2, N'Servicios de Fumigaciones', 0, CAST(N'2017-10-21 22:49:02.603' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (47, 1, N'Viveros', 0, CAST(N'2017-10-21 22:49:03.210' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (48, 1, N'Venta de Motores, Repuestos y Otros', 0, CAST(N'2017-10-21 22:49:03.273' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (49, 1, N'Joyeria y Relojeria', 0, CAST(N'2017-10-21 22:49:03.283' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (50, 1, N'Agencias de Loteria', 0, CAST(N'2017-10-21 22:49:03.557' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (51, 3, N'Heladerías', 0, CAST(N'2017-10-21 22:49:03.670' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (52, 2, N'Consultoría', 0, CAST(N'2017-10-21 22:49:05.270' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (53, 2, N'Centros de Estética', 0, CAST(N'2017-10-21 22:49:05.333' AS DateTime))
INSERT [dbo].[sociosSegmento] ([sociosSegmento_id], [sociosSegmento_rubro], [sociosSegmento_nombre], [sociosSegmento_deleted], [sociosSegmento_modificado]) VALUES (54, 2, N'Veterinarios', 0, CAST(N'2017-10-21 22:49:06.710' AS DateTime))
SET IDENTITY_INSERT [dbo].[sociosSegmento] OFF
